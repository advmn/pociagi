package app.pociag;

import app.pociag.lokomotywy.Lokomotywa;
import app.pociag.wagony.Wagon;
import app.stacje.StacjaKolejowa;
import app.wyjatki.PrzekroczonoMaksymalnaWagePociagu;
import app.wyjatki.PrzekroczonyLimitIlosciWagonow;

import java.util.*;

public class Pociag implements Runnable {
    private int id;
    private static int licznikID = 0;
    private Lokomotywa lokomotywa;
    private Set<Wagon> wagony;
    private StacjaKolejowa stacjaZrodlowa;
    private StacjaKolejowa stacjaDocelowa;

    private double obecnaMasaPociagu = 0;

    private List<StacjaKolejowa> stacjePosrednie;
    private double procentUkonczonejDrogi;
    private double procentUkonczonejDrogiPomiedzyStacjami;

    private int dlugoscTrasy = 0;
    private int pokonanaTrasa = 0;


    public Pociag(Lokomotywa lokomotywa, StacjaKolejowa stacjaZrodlowa, StacjaKolejowa stacjaDocelowa, List<StacjaKolejowa> stacjePosrednie) {
        this.id = ++licznikID;
        this.lokomotywa = lokomotywa;
        this.wagony = new HashSet<>();
        this.stacjaZrodlowa = stacjaZrodlowa;
        this.stacjaDocelowa = stacjaDocelowa;
        this.procentUkonczonejDrogi = 0;
        this.procentUkonczonejDrogiPomiedzyStacjami = 0;
        this.stacjePosrednie = stacjePosrednie;
    }

    // Gettery i settery
    public int getId() {
        return id;
    }

    public Lokomotywa getLokomotywa() {
        return lokomotywa;
    }

    public void setLokomotywa(Lokomotywa lokomotywa) {
        this.lokomotywa = lokomotywa;
    }

    public Set<Wagon> getWagony() {
        return wagony;
    }

    public void setWagony(List<Wagon> wagony) {
        sprawdzIloscWagonow(wagony.size());
        double masaPociagu = obecnaMasaPociagu + wagony.stream().mapToDouble(Wagon::getObecnaWagaWagonu).sum();
        sprawdzMasePociagu(masaPociagu);

        this.wagony.addAll(wagony);
        zwiekszMasePociagu(masaPociagu);
    }

    public StacjaKolejowa getStacjaZrodlowa() {
        return stacjaZrodlowa;
    }

    public StacjaKolejowa getStacjaDocelowa() {
        return stacjaDocelowa;
    }

    public double getProcentUkonczonejDrogi() {
        return procentUkonczonejDrogi;
    }

    // Metody
    public void dodajWagon(Wagon wagon) {
        sprawdzIloscWagonow(1);

        double masaPociagu = obecnaMasaPociagu + wagon.getObecnaWagaWagonu();
        sprawdzMasePociagu(masaPociagu);

        zwiekszMasePociagu(masaPociagu);
        wagony.add(wagon);
    }

    public boolean usunWagon(Wagon wagon) {
        return wagony.remove(wagon);
    }

    private void sprawdzMasePociagu(double waga) {
        double wagaPociagu = obecnaMasaPociagu + waga;
        if (wagaPociagu > lokomotywa.getMaxWagaLadunku()) {
            throw new PrzekroczonoMaksymalnaWagePociagu();
        }
    }

    private void sprawdzIloscWagonow(int ilosc) {
        int iloscWagonow = wagony.size() + ilosc;
        if (iloscWagonow > lokomotywa.getMaxLiczbaWagonow()) {
            throw new PrzekroczonyLimitIlosciWagonow();
        }
    }

    private void zwiekszMasePociagu(double masa) {
        obecnaMasaPociagu += masa;
    }

    private void obliczDlugoscTrasy() {
        StacjaKolejowa obecnaStacja = stacjaZrodlowa;
        for (StacjaKolejowa stacjaKolejowa : stacjePosrednie) {
            int odleglosc = obecnaStacja.getPolaczenia().stream()
                    .filter(item -> item.getStacjaDocelowa().getNazwa().equals(stacjaKolejowa.getNazwa()))
                    .findFirst().get().getOdleglosc();

            dlugoscTrasy += odleglosc;
            obecnaStacja = stacjaKolejowa;
        }
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("stacja zrodlowa: " + stacjaZrodlowa.getNazwa());
            StacjaKolejowa obecnaStacja = stacjaZrodlowa;
            obliczDlugoscTrasy();
            for (StacjaKolejowa stacjaPosrednia : stacjePosrednie) {
                System.out.println("pokonana trasa: " + procentUkonczonejDrogi);
                int odleglosc = getOdlegloscOdStacji(obecnaStacja, stacjaPosrednia);
                jedzDoNastepnejStacji(odleglosc);
                System.out.println("stacja posrednia: " + stacjaPosrednia.getNazwa());
                postojNaStacji(2L);
                obecnaStacja = stacjaPosrednia;
            }
            int odleglosdOdStacjiDocelowej = getOdlegloscOdStacji(obecnaStacja, stacjaDocelowa);
            jedzDoNastepnejStacji(odleglosdOdStacjiDocelowej);
            System.out.println("stacja docelowa " + stacjaDocelowa.getNazwa());
            postojNaStacji(30L);
            odwrocKierunek();
        }

    }

    private void odwrocKierunek() {
        StacjaKolejowa temp = stacjaZrodlowa;
        stacjaZrodlowa = stacjaDocelowa;
        stacjaDocelowa = temp;
        Collections.reverse(stacjePosrednie);
    }

    private int getOdlegloscOdStacji(StacjaKolejowa obecnaStacja, StacjaKolejowa stacjaDocelowa) {
        return obecnaStacja.getPolaczenia().stream()
                .filter(item -> item.getStacjaDocelowa().getNazwa().equals(stacjaDocelowa.getNazwa()))
                .findFirst().get().getOdleglosc();
    }

    private void postojNaStacji(long czas) {
        try {
            Thread.sleep(czas * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void jedzDoNastepnejStacji(int odleglosc) {
        int czasDoNastepnejStacji = wyliczCzasDoNastepnejStacji(odleglosc);
        int licznikCzasu = 0;
        int pokonanaTrasaMIedzyStacjami = 0;
        while (licznikCzasu < czasDoNastepnejStacji) {
            try {
                Thread.sleep(100);
                wyliczPredkoscLokomotywy();
                czasDoNastepnejStacji = wyliczCzasDoNastepnejStacji(odleglosc);
                int trasaNaJednostkeCzasu = odleglosc * 1000 / czasDoNastepnejStacji;
                pokonanaTrasa += trasaNaJednostkeCzasu;
                pokonanaTrasaMIedzyStacjami += trasaNaJednostkeCzasu;
                procentUkonczonejDrogi = pokonanaTrasa * 100 / dlugoscTrasy;
                procentUkonczonejDrogiPomiedzyStacjami = pokonanaTrasaMIedzyStacjami * 100 / odleglosc;
                licznikCzasu += 1000;

                System.out.println("pokonana trasa miedzy stacjami: " + procentUkonczonejDrogiPomiedzyStacjami);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private int wyliczCzasDoNastepnejStacji(int odleglosc) {
        return (odleglosc * 10 / lokomotywa.getPredkosc()) * 1000;
    }

    private void wyliczPredkoscLokomotywy() {
        Random random = new Random();
        int speed = random.nextInt(2);
        int procent = (lokomotywa.getPredkosc() * 3) / 100;
        if (speed == 1) {
            lokomotywa.setPredkosc(lokomotywa.getPredkosc() - procent);
        } else {
            lokomotywa.setPredkosc(lokomotywa.getPredkosc() + procent);
        }
    }
}

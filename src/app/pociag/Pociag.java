package app.pociag;

import app.pociag.lokomotywy.Lokomotywa;
import app.pociag.wagony.Wagon;
import app.stacje.StacjaKolejowa;
import app.wyjatki.PrzekroczonoMaksymalnaWagePociagu;
import app.wyjatki.PrzekroczonyLimitIlosciWagonow;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
        StacjaKolejowa obecnaStacja = stacjaZrodlowa;
        int czasDoNastepnejStacji = 0;
        while (true) {
            for (StacjaKolejowa stacjaPosrednia : stacjePosrednie) {
                int odleglosc = obecnaStacja.getPolaczenia().stream()
                        .filter(item -> item.getStacjaDocelowa().getNazwa().equals(stacjaPosrednia.getNazwa()))
                        .findFirst().get().getOdleglosc();
                czasDoNastepnejStacji = (odleglosc / lokomotywa.getPredkosc()) * 1000;

                int licznikCzasu = 0;
                while(licznikCzasu < czasDoNastepnejStacji) {
                    try {
                        Thread.sleep(1000);
                        wyliczPredkoscLokomotywy();
                        wyliczCzasDoNastepnejStacji(odleglosc);
                        licznikCzasu++;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    private int wyliczCzasDoNastepnejStacji(int odleglosc) {
        return  (odleglosc / lokomotywa.getPredkosc()) * 1000;
    }

    private void wyliczPredkoscLokomotywy() {
        Random random = new Random();
        int speed = random.nextInt(2);
        int procent = (lokomotywa.getPredkosc() * 3) / 100;
        if(speed == 1) {
            lokomotywa.setPredkosc(lokomotywa.getPredkosc() - procent);
        } else {
            lokomotywa.setPredkosc(lokomotywa.getPredkosc() + procent);
        }
    }
}

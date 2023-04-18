package app.stacje;

import java.util.ArrayList;
import java.util.List;

public class StacjaKolejowa {
    private String nazwa;
    private List<Polaczenie> polaczenia;

    public StacjaKolejowa(String nazwa) {
        this.nazwa = nazwa;
        this.polaczenia = new ArrayList<>();
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Polaczenie> getPolaczenia() {
        return polaczenia;
    }

    public void dodajPolaczenie(StacjaKolejowa stacjaDocelowa, int odleglosc) {
        Polaczenie polaczenie = new Polaczenie(stacjaDocelowa, odleglosc);
        this.polaczenia.add(polaczenie);
    }

    public void usunPolaczenie(StacjaKolejowa stacjaDocelowa) {
        polaczenia.removeIf(polaczenie -> polaczenie.getStacjaDocelowa().equals(stacjaDocelowa));
    }

    public void wyswietlPolaczenia() {
        System.out.println("Stacja: " + nazwa);
        System.out.println("Połączenia:");
        for (Polaczenie polaczenie : polaczenia) {
            System.out.println("- " + polaczenie.getStacjaDocelowa().getNazwa() + ", odległość: " + polaczenie.getOdleglosc() + " km");
        }
    }

    class Polaczenie {
        private StacjaKolejowa stacjaDocelowa;
        private int odleglosc;

        public Polaczenie(StacjaKolejowa stacjaDocelowa, int odleglosc) {
            this.stacjaDocelowa = stacjaDocelowa;
            this.odleglosc = odleglosc;
        }

        public StacjaKolejowa getStacjaDocelowa() {
            return stacjaDocelowa;
        }

        public int getOdleglosc() {
            return odleglosc;
        }
    }
}

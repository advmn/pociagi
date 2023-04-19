package app.pociag.lokomotywy;

import app.stacje.StacjaKolejowa;

public class Lokomotywa {
    private static int licznikID = 0;
    private int id;
    private String nazwa;
    private StacjaKolejowa stacjaMacierzysta;
    private StacjaKolejowa stacjaZrodlowa;
    private StacjaKolejowa stacjaDocelowa;
    private int maxLiczbaWagonow;
    private double maxWagaLadunku;
    private int maxLiczbaWagonowElektrycznych;
    private int predkosc;


    private int obecnaLiczbaWagonowELektrycznych;

    private double obecnaMasaLadunku;

    public Lokomotywa(String nazwa, StacjaKolejowa stacjaMacierzysta, StacjaKolejowa stacjaZrodlowa, StacjaKolejowa stacjaDocelowa, int maxLiczbaWagonow, double maxWagaLadunku, int maxLiczbaWagonowElektrycznych, int predkosc) {
        this.id = ++licznikID;
        this.nazwa = nazwa;
        this.stacjaMacierzysta = stacjaMacierzysta;
        this.stacjaZrodlowa = stacjaZrodlowa;
        this.stacjaDocelowa = stacjaDocelowa;
        this.maxLiczbaWagonow = maxLiczbaWagonow;
        this.maxWagaLadunku = maxWagaLadunku;
        this.maxLiczbaWagonowElektrycznych = maxLiczbaWagonowElektrycznych;
        this.predkosc = predkosc;
        this.obecnaLiczbaWagonowELektrycznych = obecnaLiczbaWagonowELektrycznych;
        this.obecnaMasaLadunku = obecnaMasaLadunku;
    }

    public Lokomotywa(int i, int i1, int i2) {
    }

    // Gettery i settery
    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public StacjaKolejowa getStacjaMacierzysta() {
        return stacjaMacierzysta;
    }

    public void setStacjaMacierzysta(StacjaKolejowa stacjaMacierzysta) {
        this.stacjaMacierzysta = stacjaMacierzysta;
    }

    public StacjaKolejowa getStacjaZrodlowa() {
        return stacjaZrodlowa;
    }

    public void setStacjaZrodlowa(StacjaKolejowa stacjaZrodlowa) {
        this.stacjaZrodlowa = stacjaZrodlowa;
    }

    public StacjaKolejowa getStacjaDocelowa() {
        return stacjaDocelowa;
    }

    public void setStacjaDocelowa(StacjaKolejowa stacjaDocelowa) {
        this.stacjaDocelowa = stacjaDocelowa;
    }

    public int getMaxLiczbaWagonow() {
        return maxLiczbaWagonow;
    }

    public void setMaxLiczbaWagonow(int maxLiczbaWagonow) {
        this.maxLiczbaWagonow = maxLiczbaWagonow;
    }

    public double getMaxWagaLadunku() {
        return maxWagaLadunku;
    }

    public void setMaxWagaLadunku(int max) {

    }

    public boolean czyMoznaPodpiacWagon() {

        return obecnaLiczbaWagonowELektrycznych < maxLiczbaWagonowElektrycznych;
    }

    public void dodajElektrycznyWagon() {
        ++obecnaLiczbaWagonowELektrycznych;
        if (!czyMoznaPodpiacWagon()) {
            --obecnaLiczbaWagonowELektrycznych;
            throw new RuntimeException("Nie można dodać pociągu ponieważ, " +
                    "skład osiągnął maksymalną liczbę elektrycznych wagonów");
        }
    }

    public void zwiekszMaseLadunku(double masaLadunku) {
        obecnaMasaLadunku += masaLadunku;
        if (obecnaMasaLadunku > maxWagaLadunku) {
            obecnaMasaLadunku -= masaLadunku;
            throw new RuntimeException("Nie można dodać więcej ładunku ponieważ, masa jest zbyt duża");
        }
    }

    public int getPredkosc() {
        return predkosc;
    }

    public void setPredkosc(int predkosc) {
        this.predkosc = predkosc;
    }
}

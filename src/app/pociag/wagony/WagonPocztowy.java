package app.pociag.wagony;

public class WagonPocztowy extends Wagon {
    private boolean wymagaPodłączeniaDoSieciElektrycznej;

    public WagonPocztowy(double waga, boolean wymagaPodłączeniaDoSieciElektrycznej) {
        super(waga);
        this.wymagaPodłączeniaDoSieciElektrycznej = wymagaPodłączeniaDoSieciElektrycznej;
    }

    public boolean isWymagaPodłączeniaDoSieciElektrycznej() {
        return wymagaPodłączeniaDoSieciElektrycznej;
    }

    public void setWymagaPodłączeniaDoSieciElektrycznej(boolean wymagaPodłączeniaDoSieciElektrycznej) {
        this.wymagaPodłączeniaDoSieciElektrycznej = wymagaPodłączeniaDoSieciElektrycznej;
    }
}

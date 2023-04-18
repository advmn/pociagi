package app.pociag.wagony;

public class WagonPocztowy extends Wagon {
    private boolean wymagaPodlaczeniaDoSieciElektrycznej;

    public WagonPocztowy(double waga, boolean wymagaPodlączeniaDoSieciElektrycznej) {
        super(waga, waga);
        this.wymagaPodlaczeniaDoSieciElektrycznej = wymagaPodlączeniaDoSieciElektrycznej;
    }

    public boolean isWymagaPodlaczeniaDoSieciElektrycznej() {
        return wymagaPodlaczeniaDoSieciElektrycznej;
    }

    public void setWymagaPodlaczeniaDoSieciElektrycznej(boolean wymagaPodlaczeniaDoSieciElektrycznej) {
        this.wymagaPodlaczeniaDoSieciElektrycznej = wymagaPodlaczeniaDoSieciElektrycznej;
    }

    @Override
    public void wyswietlInformacje() {

    }
}

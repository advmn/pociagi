package app.pociag.wagony;

public abstract class WagonTowarowyCiezki extends Wagon {
    private String rodzajTowaru;

    public WagonTowarowyCiezki(double wagaPustegoWagonu, double maksymalnaWagaWagonu, String rodzajTowaru) {
        super(wagaPustegoWagonu, maksymalnaWagaWagonu);
        this.rodzajTowaru = rodzajTowaru;
    }

    public String getRodzajTowaru() {
        return rodzajTowaru;
    }

    public void setRodzajTowaru(String rodzajTowaru) {
        this.rodzajTowaru = rodzajTowaru;
    }

    @Override
    public void wyswietlInformacje() {

    }
}

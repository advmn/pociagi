package app.pociag.wagony;

public class WagonBagazowoPocztowy extends Wagon {
    private double wagaBagazu; // w metrach sześciennych
    private double wagaSkrzynPocztowych;

    public WagonBagazowoPocztowy(double wagaPustegoWagonu, double maksymalnaWagaWagonu, double wagaBagazu, double wagaSkrzynPocztowych) {
        super(wagaPustegoWagonu, maksymalnaWagaWagonu);
        this.wagaBagazu = wagaBagazu;
        this.wagaSkrzynPocztowych = wagaSkrzynPocztowych;
    }

    // Getters and setters
    public double getWagaBagazu() {
        return wagaBagazu;
    }

    public void setWagaBagazu(double wagaBagazu) {
        this.wagaBagazu = wagaBagazu;
    }

    public double getWagaSkrzynPocztowych() {
        return wagaSkrzynPocztowych;
    }

    public void setWagaSkrzynPocztowych(double wagaSkrzynPocztowych) {
        this.wagaSkrzynPocztowych = wagaSkrzynPocztowych;
    }

    @Override
    public void wyswietlInformacje() {

    }
}


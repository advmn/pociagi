package app.pociag.wagony;

public abstract class Wagon {
    private static int counter = 0;
    protected int numerIdentyfikacyjny;
    protected double wagaNetto;
    protected double wagaBrutto;

    public Wagon(double wagaNetto, double wagaBrutto) {
        this.numerIdentyfikacyjny = ++counter;
        this.wagaNetto = wagaNetto;
        this.wagaBrutto = wagaBrutto;
    }

    public int getNumerIdentyfikacyjny() {
        return numerIdentyfikacyjny;
    }

    public double getWagaNetto() {
        return wagaNetto;
    }

    public void setWagaNetto(double wagaNetto) {
        this.wagaNetto = wagaNetto;
    }

    public double getWagaBrutto() {
        return wagaBrutto;
    }

    public void setWagaBrutto(double wagaBrutto) {
        this.wagaBrutto = wagaBrutto;
    }

    public abstract void wyswietlInformacje();
}






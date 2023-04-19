package app.pociag.wagony;

public abstract class Wagon {
    private static int counter = 0;
    protected int numerIdentyfikacyjny;
    protected double wagePustegoWagonu;
    protected double maksymalnaWagaWagonu;

    protected double obecnaWagaWagonu;

    public Wagon(double wagaPustegoWagonu, double wagaPelnegoWagonu) {
        this.numerIdentyfikacyjny = ++counter;
        this.wagePustegoWagonu = wagaPustegoWagonu;
        this.maksymalnaWagaWagonu = wagaPelnegoWagonu;
        this.obecnaWagaWagonu = wagaPustegoWagonu;
    }

    public int getNumerIdentyfikacyjny() {
        return numerIdentyfikacyjny;
    }

    public double getWagePustegoWagonu() {
        return wagePustegoWagonu;
    }

    public void setWagePustegoWagonu(double wagePustegoWagonu) {
        this.wagePustegoWagonu = wagePustegoWagonu;
    }

    public double getMaksymalnaWagaWagonu() {
        return maksymalnaWagaWagonu;
    }

    public void setMaksymalnaWagaWagonu(double maksymalnaWagaWagonu) {
        this.maksymalnaWagaWagonu = maksymalnaWagaWagonu;
    }

    public abstract void wyswietlInformacje();

    public double getObecnaWagaWagonu() {
        return obecnaWagaWagonu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wagon wagon = (Wagon) o;

        return numerIdentyfikacyjny == wagon.numerIdentyfikacyjny;
    }

    @Override
    public int hashCode() {
        return numerIdentyfikacyjny;
    }
}






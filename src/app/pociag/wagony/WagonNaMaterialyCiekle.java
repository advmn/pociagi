package app.pociag.wagony;

public class WagonNaMaterialyCiekle extends WagonTowarowyPodstawowy {
    private double pojemnoscZbiornika;
    private double gestoscCieczy;

    public WagonNaMaterialyCiekle(double wagaPustegoWagonu, double maksymalnaWagaWagonu, double pojemnoscZbiornika, double gestoscCieczy) {
        super(wagaPustegoWagonu, maksymalnaWagaWagonu);
        this.pojemnoscZbiornika = pojemnoscZbiornika;
        this.gestoscCieczy = gestoscCieczy;
    }

    public double getPojemnoscZbiornika() {
        return pojemnoscZbiornika;
    }

    public void setPojemnoscZbiornika(double pojemnoscZbiornika) {
        this.pojemnoscZbiornika = pojemnoscZbiornika;
    }

    public double getGestoscCieczy() {
        return gestoscCieczy;
    }

    public void setGestoscCieczy(double gestoscCieczy) {
        this.gestoscCieczy = gestoscCieczy;
    }
}

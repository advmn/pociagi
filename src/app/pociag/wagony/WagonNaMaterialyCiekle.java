package app.pociag.wagony;

public class WagonNaMaterialyCiekle extends WagonTowarowyPodstawowy {
    private double pojemnoscZbiornika;

    public WagonNaMaterialyCiekle(double waga, double wagaNetto, double wagaBrutto, double pojemnoscZbiornika) {
        super(waga, wagaNetto, wagaBrutto);
        this.pojemnoscZbiornika = pojemnoscZbiornika;
    }

    public double getPojemnoscZbiornika() {
        return pojemnoscZbiornika;
    }

    public void setPojemnoscZbiornika(double pojemnoscZbiornika) {
        this.pojemnoscZbiornika = pojemnoscZbiornika;
    }
}

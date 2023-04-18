package app.pociag.wagony;

public class WagonNaMaterialyGazowe extends WagonTowarowyPodstawowy {
    private double pojemnoscZbiornika;

    public WagonNaMaterialyGazowe(double waga, double wagaNetto, double wagaBrutto, double pojemnoscZbiornika) {
        super(waga, wagaNetto, wagaBrutto);
        this.pojemnoscZbiornika = pojemnoscZbiornika;
    }

    // Getters and setters
    public double getPojemnoscZbiornika() {
        return pojemnoscZbiornika;
    }

    public void setPojemnoscZbiornika(double pojemnoscZbiornika) {
        this.pojemnoscZbiornika = pojemnoscZbiornika;
    }
}


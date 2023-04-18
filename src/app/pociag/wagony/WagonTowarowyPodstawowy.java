package app.pociag.wagony;

public class WagonTowarowyPodstawowy extends Wagon {
    private double wagaNetto;
    private double wagaBrutto;

    public WagonTowarowyPodstawowy(double waga, double wagaNetto, double wagaBrutto) {
        super(waga);
        this.wagaNetto = wagaNetto;
        this.wagaBrutto = wagaBrutto;
    }

    // Getters and setters
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
}

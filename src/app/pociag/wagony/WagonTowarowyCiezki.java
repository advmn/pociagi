package app.pociag.wagony;

public class WagonTowarowyCiezki extends WagonTowarowyPodstawowy {
    private double maksymalneObciazenie;
    private String rodzajTowaru;

    public WagonTowarowyCiezki(double waga, double wagaNetto, double wagaBrutto, double maksymalneObciazenie, String rodzajTowaru) {
        super(waga, wagaNetto, wagaBrutto);
        this.maksymalneObciazenie = maksymalneObciazenie;
        this.rodzajTowaru = rodzajTowaru;
    }

    // Getters and setters
    public double getMaksymalneObciazenie() {
        return maksymalneObciazenie;
    }

    public void setMaksymalneObciazenie(double maksymalneObciazenie) {
        this.maksymalneObciazenie = maksymalneObciazenie;
    }

    public String getRodzajTowaru() {
        return rodzajTowaru;
    }

    public void setRodzajTowaru(String rodzajTowaru) {
        this.rodzajTowaru = rodzajTowaru;
    }
}

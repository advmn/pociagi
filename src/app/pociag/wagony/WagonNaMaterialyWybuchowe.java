package app.pociag.wagony;

public class WagonNaMaterialyWybuchowe extends WagonTowarowyCiezki {
    private double iloscMateriowWybuchowych;

    public WagonNaMaterialyWybuchowe(double waga, double wagaNetto, double wagaBrutto, double iloscMateriowWybuchowych) {
        super(waga, wagaNetto, wagaBrutto);
        this.iloscMateriowWybuchowych = iloscMateriowWybuchowych;
    }

    public double getIloscMateriowWybuchowych() {
        return iloscMateriowWybuchowych;
    }

    public void setIloscMateriowWybuchowych(double iloscMateriowWybuchowych) {
        this.iloscMateriowWybuchowych = iloscMateriowWybuchowych;
    }
}

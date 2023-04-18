package app.pociag.wagony;

public class WagonNaMaterialyWybuchowe extends WagonTowarowyCiezki {

    private double ilośćStrzynZMaterialamiWybuchowymi;
    private double wagaJednejSkrzyni;


    public WagonNaMaterialyWybuchowe(double wagaPustegoWagonu, double maksymalnaWagaWagonu, double wagaJednejSkrzyni) {
        super(wagaPustegoWagonu, maksymalnaWagaWagonu, "Materialy Wybuchowe");
        this.wagaJednejSkrzyni = wagaJednejSkrzyni;
    }

    public double getWagaJednejSkrzyni() {
        return wagaJednejSkrzyni;
    }

    public double getIlośćStrzynZMaterialamiWybuchowymi() {
        return ilośćStrzynZMaterialamiWybuchowymi;
    }

    public void setIlośćStrzynZMaterialamiWybuchowymi(double ilośćStrzynZMaterialamiWybuchowymi) {
        this.ilośćStrzynZMaterialamiWybuchowymi = ilośćStrzynZMaterialamiWybuchowymi;
    }
}

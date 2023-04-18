package app.pociag.wagony;

public class WagonNaMaterialyToksyczne extends WagonTowarowyCiezki {

    private double wagaSkrzyni;
    private double iloscSkrzyn;

    public WagonNaMaterialyToksyczne(double wagaPustegoWagonu, double maksymalnaWagaWagonu, double wagaSkrzyni) {
        super(wagaPustegoWagonu, maksymalnaWagaWagonu, "Materialy toksyczne");
        this.wagaSkrzyni = wagaSkrzyni;
    }

    public double getWagaSkrzyni() {
        return wagaSkrzyni;
    }

    public double getIloscSkrzyn() {
        return iloscSkrzyn;
    }

    public void setIloscSkrzyn(double iloscSkrzyn) {
        this.iloscSkrzyn = iloscSkrzyn;
    }



}


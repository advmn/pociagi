package app.pociag.wagony;

public class WagonNaCiekleMaterialyToksyczne extends WagonTowarowyCiezki {
    private double pojemnoscZbiornika;
    private double iloscCieklychMaterialowToksycznych;

    public WagonNaCiekleMaterialyToksyczne(double wagaPustegoWagonu, double maksymalnaWagaWagonu, double maksymalnaPojemnoscZbiornika, double iloscCieklychMaterialowToksycznych) {
        super(wagaPustegoWagonu, maksymalnaWagaWagonu, "Toksyczne materialy");
        this.pojemnoscZbiornika = maksymalnaPojemnoscZbiornika;
        this.iloscCieklychMaterialowToksycznych = iloscCieklychMaterialowToksycznych;
    }
    public double getPojemnoscZbiornika() {
        return pojemnoscZbiornika;
    }

    public void setPojemnoscZbiornika(double pojemnoscZbiornika) {
        this.pojemnoscZbiornika = pojemnoscZbiornika;
    }

    public double getIloscCieklychMaterialowToksycznych() {
        return iloscCieklychMaterialowToksycznych;
    }

    public void setIloscCieklychMaterialowToksycznych(double iloscCieklychMaterialowToksycznych) {
        this.iloscCieklychMaterialowToksycznych = iloscCieklychMaterialowToksycznych;
    }
}


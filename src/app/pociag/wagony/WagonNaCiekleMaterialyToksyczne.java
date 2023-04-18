package app.pociag.wagony;

public class WagonNaCiekleMaterialyToksyczne extends WagonTowarowyCiezki {
    private double pojemnoscZbiornika;
    private double iloscCieklychMaterialowToksycznych;

    public WagonNaCiekleMaterialyToksyczne(double waga, double wagaNetto, double wagaBrutto, double pojemnoscZbiornika, double iloscCieklychMaterialowToksycznych) {
        super(waga, wagaNetto, wagaBrutto);
        this.pojemnoscZbiornika = pojemnoscZbiornika;
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


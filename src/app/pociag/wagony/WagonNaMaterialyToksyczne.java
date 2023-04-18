package app.pociag.wagony;

public class WagonNaMaterialyToksyczne extends WagonTowarowyCiezki {
    private double iloscMaterialowToksycznych;

    public WagonNaMaterialyToksyczne(double waga, double wagaNetto, double wagaBrutto, double iloscMaterialowToksycznych) {
        super(waga, wagaNetto, wagaBrutto);
        this.iloscMaterialowToksycznych = iloscMaterialowToksycznych;
    }

    public double getIloscMaterialowToksycznych() {
        return iloscMaterialowToksycznych;
    }

    public void setIloscMaterialowToksycznych(double iloscMaterialowToksycznych) {
        this.iloscMaterialowToksycznych = iloscMaterialowToksycznych;
    }
}


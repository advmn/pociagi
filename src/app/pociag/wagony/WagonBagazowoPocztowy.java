package app.pociag.wagony;

public class WagonBagazowoPocztowy extends Wagon {
    private double pojemnoscBagazu; // w metrach sześciennych
    private int liczbaSkrzynPocztowych;

    public WagonBagazowoPocztowy(double waga, double pojemnoscBagazu, int liczbaSkrzynPocztowych) {
        super(waga);
        this.pojemnoscBagazu = pojemnoscBagazu;
        this.liczbaSkrzynPocztowych = liczbaSkrzynPocztowych;
    }

    // Getters and setters
    public double getPojemnoscBagazu() {
        return pojemnoscBagazu;
    }

    public void setPojemnoscBagazu(double pojemnoscBagazu) {
        this.pojemnoscBagazu = pojemnoscBagazu;
    }

    public int getLiczbaSkrzynPocztowych() {
        return liczbaSkrzynPocztowych;
    }

    public void setLiczbaSkrzynPocztowych(int liczbaSkrzynPocztowych) {
        this.liczbaSkrzynPocztowych = liczbaSkrzynPocztowych;
    }
}


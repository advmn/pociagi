package app;

import app.stacje.StacjaKolejowa;

public class Polaczenie {
    private StacjaKolejowa stacjaPoczatkowa;
    private StacjaKolejowa stacjaKoncowa;
    private int odleglosc;

    public Polaczenie(StacjaKolejowa stacjaPoczatkowa, StacjaKolejowa stacjaKoncowa, int odleglosc) {
        this.stacjaPoczatkowa = stacjaPoczatkowa;
        this.stacjaKoncowa = stacjaKoncowa;
        this.odleglosc = odleglosc;
    }

    public StacjaKolejowa getStacjaPoczatkowa() {
        return stacjaPoczatkowa;
    }

    public void setStacjaPoczatkowa(StacjaKolejowa stacjaPoczatkowa) {
        this.stacjaPoczatkowa = stacjaPoczatkowa;
    }

    public StacjaKolejowa getStacjaKoncowa() {
        return stacjaKoncowa;
    }

    public void setStacjaKoncowa(StacjaKolejowa stacjaKoncowa) {
        this.stacjaKoncowa = stacjaKoncowa;
    }

    public int getOdleglosc() {
        return odleglosc;
    }

    public void setOdleglosc(int odleglosc) {
        this.odleglosc = odleglosc;
    }

    @Override
    public String toString() {
        return "Połączenie: " +
                "stacja początkowa: " + stacjaPoczatkowa.getNazwa() +
                ", stacja końcowa: " + stacjaKoncowa.getNazwa() +
                ", odległość: " + odleglosc + " km";
    }
}

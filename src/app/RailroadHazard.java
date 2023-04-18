package app;

import app.pociag.Pociag;

public class RailroadHazard extends Exception {
    private Pociag pociag;

    public RailroadHazard(Pociag pociag) {
        super("Pociąg " + pociag.getId() + " przekroczył dozwoloną prędkość!");
        this.pociag = pociag;
    }

    public Pociag getPociag() {
        return pociag;
    }
}

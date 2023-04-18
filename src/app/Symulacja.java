package app;

import app.Polaczenie;
import app.pociag.Pociag;
import app.stacje.StacjaKolejowa;

import java.util.ArrayList;
import java.util.List;

public class Symulacja {
    private List<StacjaKolejowa> stacjeKolejowe;
    private List<Pociag> pociagi;

    public Symulacja() {
        this.stacjeKolejowe = new ArrayList<>();
        this.pociagi = new ArrayList<>();
    }

    // Gettery i settery
    public List<StacjaKolejowa> getStacjeKolejowe() {
        return stacjeKolejowe;
    }

    public void setStacjeKolejowe(List<StacjaKolejowa> stacjeKolejowe) {
        this.stacjeKolejowe = stacjeKolejowe;
    }

    public List<Pociag> getPociagi() {
        return pociagi;
    }

    public void setPociagi(List<Pociag> pociagi) {
        this.pociagi = pociagi;
    }

    // Metody
    public void dodajStacjeKolejowa(StacjaKolejowa stacja) {
        stacjeKolejowe.add(stacja);
    }

    public void dodajPociag(Pociag pociag) {
        pociagi.add(pociag);
    }

    public void aktualizujProcentUkonczonejDrogi(Pociag pociag, double nowyProcentUkonczonejDrogi) {
        pociag.setProcentUkonczonejDrogi(nowyProcentUkonczonejDrogi);
    }

    public void przemiescPociagDoStacjiDocelowej(Pociag pociag) {
        if (pociag.getProcentUkonczonejDrogi() == 100.0) {
            pociag.setStacjaZrodlowa(pociag.getStacjaDocelowa());
        }
    }

    public void dodajStacje(StacjaKolejowa stacja1) {
    }

    public void dodajPolaczenie(Polaczenie polaczenie) {
    }

    public void uruchom() {
    }
}

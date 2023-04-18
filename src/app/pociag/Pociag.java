package app.pociag;

import app.pociag.lokomotywy.Lokomotywa;
import app.pociag.wagony.Wagon;
import app.stacje.StacjaKolejowa;

import java.util.ArrayList;
import java.util.List;

public class Pociag {
    private int id;
    private static int licznikID = 0;
    private Lokomotywa lokomotywa;
    private List<Wagon> wagony;
    private StacjaKolejowa stacjaZrodlowa;
    private StacjaKolejowa stacjaDocelowa;
    private double procentUkonczonejDrogi;

    public Pociag(Lokomotywa lokomotywa, StacjaKolejowa stacjaZrodlowa, StacjaKolejowa stacjaDocelowa) {
        this.id = ++licznikID;
        this.lokomotywa = lokomotywa;
        this.wagony = new ArrayList<>();
        this.stacjaZrodlowa = stacjaZrodlowa;
        this.stacjaDocelowa = stacjaDocelowa;
        this.procentUkonczonejDrogi = 0;
    }

    // Gettery i settery
    public int getId() {
        return id;
    }

    public Lokomotywa getLokomotywa() {
        return lokomotywa;
    }

    public void setLokomotywa(Lokomotywa lokomotywa) {
        this.lokomotywa = lokomotywa;
    }

    public List<Wagon> getWagony() {
        return wagony;
    }

    public void setWagony(List<Wagon> wagony) {
        this.wagony = wagony;
    }

    public StacjaKolejowa getStacjaZrodlowa() {
        return stacjaZrodlowa;
    }

    public void setStacjaZrodlowa(StacjaKolejowa stacjaZrodlowa) {
        this.stacjaZrodlowa = stacjaZrodlowa;
    }

    public StacjaKolejowa getStacjaDocelowa() {
        return stacjaDocelowa;
    }

    public void setStacjaDocelowa(StacjaKolejowa stacjaDocelowa) {
        this.stacjaDocelowa = stacjaDocelowa;
    }

    public double getProcentUkonczonejDrogi() {
        return procentUkonczonejDrogi;
    }

    public void setProcentUkonczonejDrogi(double procentUkonczonejDrogi) {
        this.procentUkonczonejDrogi = procentUkonczonejDrogi;
    }

    // Metody
    public boolean dodajWagon(Wagon wagon) {
        if (wagony.size() < lokomotywa.getMaxLiczbaWagonow()) {
            wagony.add(wagon);
            return true;
        } else {
            return false;
        }
    }

    public boolean usunWagon(Wagon wagon) {
        return wagony.remove(wagon);
    }
}

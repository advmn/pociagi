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

    private List<StacjaKolejowa> stacjePosrednie;
    private double procentUkonczonejDrogi;
    private double procentUkonczonejDrogiPomiedzyStacjami;

    public Pociag(Lokomotywa lokomotywa, StacjaKolejowa stacjaZrodlowa, StacjaKolejowa stacjaDocelowa, List<StacjaKolejowa> stacjePosrednie) {
        this.id = ++licznikID;
        this.lokomotywa = lokomotywa;
        this.wagony = new ArrayList<>();
        this.stacjaZrodlowa = stacjaZrodlowa;
        this.stacjaDocelowa = stacjaDocelowa;
        this.procentUkonczonejDrogi = 0;
        this.procentUkonczonejDrogiPomiedzyStacjami = 0;
        this.stacjePosrednie = stacjePosrednie;
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
        if (wagony.size() > lokomotywa.getMaxLiczbaWagonow()) {
//            TODO throw exception
        }
        this.wagony = wagony;
    }

    public StacjaKolejowa getStacjaZrodlowa() {
        return stacjaZrodlowa;
    }

    public StacjaKolejowa getStacjaDocelowa() {
        return stacjaDocelowa;
    }

    public double getProcentUkonczonejDrogi() {
        return procentUkonczonejDrogi;
    }

    // Metody
    public void dodajWagon(Wagon wagon) {
        if (wagony.size() + 1 > lokomotywa.getMaxLiczbaWagonow()) {
//        TODO thorw exception
        }
        wagony.add(wagon);
    }

    public boolean usunWagon(Wagon wagon) {
        return wagony.remove(wagon);
    }
}

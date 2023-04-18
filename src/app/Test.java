package app;

import app.pociag.lokomotywy.Lokomotywa;
import app.pociag.wagony.WagonPasazerski;
import app.stacje.StacjaKolejowa;

public class Test {
    public static void main(String[] args) {

        Lokomotywa test = new Lokomotywa("siema",  null, null, null, 10, 1000, 3, 1);

        WagonPasazerski test1 = new WagonPasazerski(1.0, 2.0, test);

    }
}

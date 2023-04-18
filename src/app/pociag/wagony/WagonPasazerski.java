package app.pociag.wagony;


import app.pociag.lokomotywy.Lokomotywa;

public class WagonPasazerski extends Wagon {


    public WagonPasazerski(double wagaNetto, double wagaBrutto, Lokomotywa lokomotywa) {
        super(wagaNetto, wagaBrutto);
        lokomotywa.dodajElektrycznyWagon();
        lokomotywa.zwiekszMaseLadunku(wagaBrutto);
    }


    @Override
    public void wyswietlInformacje() {

    }

}

package app.pociag.wagony;


import app.wyjatki.PrzekroczonoMaksymalnaMaseWagonu;

public class WagonPasazerski extends Wagon {

    private double sredniaMasaPasazera = 70;
    private int iloscPasazerow = 0;

    public WagonPasazerski(double wagaNetto, double wagaBrutto) {
        super(wagaNetto, wagaBrutto);
    }


    @Override
    public void wyswietlInformacje() {

    }

    public void dodajPasazerow(int ilosc) {
        double masaPoDodaniuPasazerow = ilosc * sredniaMasaPasazera;
        sprawdzMaseWagonu(masaPoDodaniuPasazerow);
        obecnaWagaWagonu += masaPoDodaniuPasazerow;
        iloscPasazerow += ilosc;
    }

    public void usunPasazerow(int ilosc) {
        if (ilosc > iloscPasazerow) {
            throw new RuntimeException("Zadana ilosc pasarzerow do usuniecia jest wieksza niz obecna ilosc w wagonie");
        }
        iloscPasazerow -= ilosc;
    }

    private void sprawdzMaseWagonu(double masaPasazerow) {
        if (masaPasazerow > maksymalnaWagaWagonu) {
            throw new PrzekroczonoMaksymalnaMaseWagonu();
        }
    }

}

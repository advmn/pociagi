package app.pociag.wagony;

public class WagonRestauracyjny extends Wagon {
    private int liczbaMiejscSiedzacych;
    private boolean podlaczenieDoSieciElektrycznej;

    public WagonRestauracyjny(double waga, int liczbaMiejscSiedzacych, boolean podlaczenieDoSieciElektrycznej) {
        super(waga, waga);
        this.liczbaMiejscSiedzacych = liczbaMiejscSiedzacych;
        this.podlaczenieDoSieciElektrycznej = podlaczenieDoSieciElektrycznej;
    }

    // Getters and setters
    public int getLiczbaMiejscSiedzacych() {
        return liczbaMiejscSiedzacych;
    }

    public void setLiczbaMiejscSiedzacych(int liczbaMiejscSiedzacych) {
        this.liczbaMiejscSiedzacych = liczbaMiejscSiedzacych;
    }

    public boolean isPodlaczenieDoSieciElektrycznej() {
        return podlaczenieDoSieciElektrycznej;
    }

    public void setPodlaczenieDoSieciElektrycznej(boolean podlaczenieDoSieciElektrycznej) {
        this.podlaczenieDoSieciElektrycznej = podlaczenieDoSieciElektrycznej;
    }

    @Override
    public void wyswietlInformacje() {

    }
}

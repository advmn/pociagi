package app.pociag.wagony;

public class WagonChlodniczy extends Wagon {
    private double temperatura;
    private boolean podlaczonyDoSieciElektrycznej;

    public WagonChlodniczy(double wagaNetto, double wagaBrutto) {
        super(wagaNetto, wagaBrutto);
        this.temperatura = temperatura;
        this.podlaczonyDoSieciElektrycznej = false;
    }


    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isPodlaczonyDoSieciElektrycznej() {
        return podlaczonyDoSieciElektrycznej;
    }

    public void setPodlaczonyDoSieciElektrycznej(boolean podlaczonyDoSieciElektrycznej) {
        this.podlaczonyDoSieciElektrycznej = podlaczonyDoSieciElektrycznej;
    }

    @Override
    public void wyswietlInformacje() {

    }
}

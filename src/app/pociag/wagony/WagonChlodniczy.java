package app.pociag.wagony;

public class WagonChlodniczy extends WagonTowarowyPodstawowy implements Elektryczny {
    private double temperatura;
    private boolean podlaczonyDoSieciElektrycznej;

    public WagonChlodniczy(double waga, double wagaNetto, double wagaBrutto, double temperatura) {
        super(waga, wagaNetto, wagaBrutto);
        this.temperatura = temperatura;
        this.podlaczonyDoSieciElektrycznej = false;
    }


    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public boolean isPodlaczonyDoSieciElektrycznej() {
        return podlaczonyDoSieciElektrycznej;
    }

    @Override
    public void setPodlaczonyDoSieciElektrycznej(boolean podlaczonyDoSieciElektrycznej) {
        this.podlaczonyDoSieciElektrycznej = podlaczonyDoSieciElektrycznej;
    }
}

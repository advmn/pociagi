package app.wyjatki;

public class PrzekroczonoMaksymalnaWagePociagu extends RuntimeException {

    public PrzekroczonoMaksymalnaWagePociagu() {
        super("przekroczono maksymalna wage pociagu");
    }
}

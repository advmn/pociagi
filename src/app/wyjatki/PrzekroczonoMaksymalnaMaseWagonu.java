package app.wyjatki;

public class PrzekroczonoMaksymalnaMaseWagonu extends RuntimeException {

    public PrzekroczonoMaksymalnaMaseWagonu() {
        super("przekroczono maksymalna mase wagonu");
    }
}

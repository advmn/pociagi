package app.wyjatki;

public class PrzekroczonyLimitIlosciWagonow extends RuntimeException {

    public PrzekroczonyLimitIlosciWagonow() {
        super("przekroczono limit ilosci wagonow do podpiecia");
    }
}

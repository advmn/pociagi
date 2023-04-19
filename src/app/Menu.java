package app;

import app.pociag.Pociag;
import app.pociag.wagony.Wagon;
import app.stacje.StacjaKolejowa;

import java.util.Scanner;

public class Menu {
    private Symulacja symulacja;
    private Scanner scanner;

    public Menu(Symulacja symulacja) {
        this.symulacja = symulacja;
        this.scanner = new Scanner(System.in);
    }

    public void wyswietlMenu() {
        System.out.println("Witaj w symulatorze ruchu pociągów!");
        System.out.println("Wybierz opcję:");
        System.out.println("1. Dodaj stację kolejową");
        System.out.println("2. Dodaj pociąg");
        System.out.println("3. Wyświetl app.stacje kolejowe");
        System.out.println("4. Wyświetl pociągi");
        System.out.println("5. Wyjdź");
    }

    public void obslugaMenu() {
        int wybor;
        do {
            wyswietlMenu();
            wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    dodajStacjeKolejowa();
                    break;
                case 2:
                    dodajPociag();
                    break;
                case 3:
                    wyswietlStacjeKolejowe();
                    break;
                case 4:
                    wyswietlPociagi();
                    break;
                case 5:
                    System.out.println("Do widzenia!");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                    break;
            }
        } while (wybor != 5);
    }

    private void dodajStacjeKolejowa() {
        System.out.println("Podaj nazwę stacji kolejowej:");
        String nazwa = scanner.nextLine();
        StacjaKolejowa stacja = new StacjaKolejowa(nazwa);
        symulacja.dodajStacjeKolejowa(stacja);
        System.out.println("Stacja kolejowa dodana!");
    }

    private void dodajPociag() {
        boolean shouldContinue = true;
        System.out.println("Dodawanie lokomotywe: ");
        System.out.println("Nazwa lokomotywy: ");
        String nazwaLokomotywy = scanner.nextLine();

        while(shouldContinue) {
            System.out.println("Dodaj Loko");;
        }
    }

    private void wyswietlStacjeKolejowe() {
        System.out.println("Stacje kolejowe:");
        for (StacjaKolejowa stacja : symulacja.getStacjeKolejowe()) {
            System.out.println(stacja.getNazwa());
        }
    }

    private void wyswietlPociagi() {
        System.out.println("Pociągi:");
        for (Pociag pociag : symulacja.getPociagi()) {
            System.out.println("ID pociągu: " + pociag.getId());
        }
    }

    public void dodajWagon() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz rodzaj wagonu:");
        System.out.println("1. Wagon pasażerski");
        System.out.println("2. Wagon pocztowy");

        int wybor = scanner.nextInt();

        Wagon nowyWagon;
        switch (wybor) {
            case 1:

                System.out.println("Podaj liczbę miejsc siedzących:");
                int miejscaSiedzace = scanner.nextInt();
                System.out.println("Podaj liczbę miejsc stojących:");
                int miejscaStojace = scanner.nextInt();
//                nowyWagon = new WagonPasazerski(miejscaSiedzace, miejscaStojace);
                break;
            case 2:

                System.out.println("Podaj przestrzeń ładunkową:");
                double przestrzenLadunkowa = scanner.nextDouble();
//                nowyWagon = new WagonPocztowy(przestrzenLadunkowa);
                break;

            default:
                System.out.println("Nieprawidłowy wybór.");
                return;
        }

//        Wagon.add(nowyWagon);
//        System.out.println("Wagon został dodany.");
    }

}

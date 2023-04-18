package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Dodaj wagon");
            System.out.println("2. Wyświetl listę wagonów");
            System.out.println("3. Dodaj pociąg");
            System.out.println("4. Wyświetl listę pociągów");
            System.out.println("5. Dodaj stację kolejową");
            System.out.println("6. Wyświetl listę stacji kolejowych");
            System.out.println("7. Dodaj połączenie");
            System.out.println("8. Wyświetl listę połączeń");
            System.out.println("9. Wyszukaj połączenie");
            System.out.println("10. Wyjście");

            System.out.print("Wybierz opcję: ");
            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    menu.dodajWagon();
                    break;
                case 2:
                    menu.wyswietlListeWagonow();
                    break;
                case 3:
                    menu.dodajPociag();
                    break;
                case 4:
                    menu.wyswietlListePociagow();
                    break;
                case 5:
                    menu.dodajStacjeKolejowa();
                    break;
                case 6:
                    menu.wyswietlListeStacjiKolejowych();
                    break;
                case 7:
                    menu.dodajPolaczenie();
                    break;
                case 8:
                    menu.wyswietlListePolaczen();
                    break;
                case 9:
                    menu.wyszukajPolaczenie();
                    break;
                case 10:
                    System.out.println("Koniec programu.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }
}

package app;

import app.pociag.Pociag;
import app.pociag.lokomotywy.Lokomotywa;
import app.stacje.StacjaKolejowa;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Menu menu = new Menu();
//        Scanner scanner = new Scanner(System.in);

        List<StacjaKolejowa> stacje = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            stacje.add(new StacjaKolejowa(UUID.randomUUID().toString()));
        }

        Random numerStacji = new Random();
        Random iloścPolaczen = new Random();
        Random odleglosc = new Random();

        stacje.forEach(stacja -> {
            int polaczenia = iloścPolaczen.nextInt(3);
            Stack<Integer> stosNumerkow = new Stack<>();
            for (int i = 0; i < polaczenia; i++) {

                int odl = odleglosc.nextInt(200) + 10;
                int indeksStacji = numerStacji.nextInt(stacje.size());
                while (stosNumerkow.contains(indeksStacji) || indeksStacji == stacje.indexOf(stacja)) {
                    indeksStacji = numerStacji.nextInt(stacje.size());
                }
                stosNumerkow.push(indeksStacji);
                StacjaKolejowa stj = stacje.get(indeksStacji);
                stacja.dodajPolaczenie(stj, odl);
            }
        });

        StacjaKolejowa stacjaZrodlowa = stacje.get(numerStacji.nextInt(stacje.size()));
        StacjaKolejowa stacjaDocelowa = stacje.get(numerStacji.nextInt(stacje.size()));
        Lokomotywa lokomotywa = new Lokomotywa("Ciufa", new StacjaKolejowa("Czarnobyl"), stacjaZrodlowa, stacjaDocelowa, 10, 400000, 4, 150);
        List<StacjaKolejowa> stacjePosrednie = new ArrayList<>();
        Stack<StacjaKolejowa> stosOdwiedzonychStacji = new Stack<>();

        znajdzPolaczenie(stacjePosrednie, stacjaZrodlowa, stacjaDocelowa, stosOdwiedzonychStacji);

        Pociag pociag = new Pociag(lokomotywa, stacjaZrodlowa, stacjaDocelowa, stacjePosrednie);

        System.out.println("pociag");


//        while (true) {
//            System.out.println("\nMenu:");
//            System.out.println("1. Dodaj wagon");
//            System.out.println("2. Wyświetl listę wagonów");
//            System.out.println("3. Dodaj pociąg");
//            System.out.println("4. Wyświetl listę pociągów");
//            System.out.println("5. Dodaj stację kolejową");
//            System.out.println("6. Wyświetl listę stacji kolejowych");
//            System.out.println("7. Dodaj połączenie");
//            System.out.println("8. Wyświetl listę połączeń");
//            System.out.println("9. Wyszukaj połączenie");
//            System.out.println("10. Wyjście");
//
//            System.out.print("Wybierz opcję: ");
//            int wybor = scanner.nextInt();
//
//            switch (wybor) {
//                case 1:
//                    menu.dodajWagon();
//                    break;
//                case 2:
//                    menu.wyswietlListeWagonow();
//                    break;
//                case 3:
//                    menu.dodajPociag();
//                    break;
//                case 4:
//                    menu.wyswietlListePociagow();
//                    break;
//                case 5:
//                    menu.dodajStacjeKolejowa();
//                    break;
//                case 6:
//                    menu.wyswietlListeStacjiKolejowych();
//                    break;
//                case 7:
//                    menu.dodajPolaczenie();
//                    break;
//                case 8:
//                    menu.wyswietlListePolaczen();
//                    break;
//                case 9:
//                    menu.wyszukajPolaczenie();
//                    break;
//                case 10:
//                    System.out.println("Koniec programu.");
//                    scanner.close();
//                    return;
//                default:
//                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
//            }
//        }
    }

    private static void znajdzPolaczenie(List<StacjaKolejowa> stacje, StacjaKolejowa stacjaZrodlowa, StacjaKolejowa stacjaDocelowa, Stack<StacjaKolejowa> odwiedzoneStacje) {

        for (StacjaKolejowa.Polaczenie pol : stacjaZrodlowa.getPolaczenia()) {
            if (pol.getStacjaDocelowa().getNazwa().equals(stacjaDocelowa.getNazwa())) {
                return;
            }
            stacje.add(pol.getStacjaDocelowa());
            znajdzPolaczenie(stacje, pol.getStacjaDocelowa(), stacjaDocelowa, odwiedzoneStacje);
        }
    }
}

package app;

import app.pociag.Pociag;
import app.pociag.lokomotywy.Lokomotywa;
import app.pociag.wagony.WagonPasazerski;
import app.stacje.StacjaKolejowa;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        List<StacjaKolejowa> stacje = new ArrayList<>();


        Random numerStacji = new Random();
        Random iloścPolaczen = new Random();
        Random odleglosc = new Random();

        stacje.add(new StacjaKolejowa("krakow glowny"));
        stacje.add(new StacjaKolejowa("krakow mydlniki"));
        stacje.add(new StacjaKolejowa("krakow zablocie"));
        stacje.add(new StacjaKolejowa("krakow bronowice"));
        stacje.add(new StacjaKolejowa("krakow zabierzow"));

        for (int i = 0; i < stacje.size(); i++) {
            if (i + 1 < stacje.size()) {
                stacje.get(i).dodajPolaczenie(stacje.get(i + 1), 12);
            }
            if (i >= 1) {
                stacje.get(i).dodajPolaczenie(stacje.get(i - 1), 12);
            }

        }

        StacjaKolejowa stacjaZrodlowa = stacje.get(0);
        StacjaKolejowa stacjaDocelowa = stacje.get(stacje.size() - 1);
        Lokomotywa lokomotywa = new Lokomotywa("Ciufa", new StacjaKolejowa("Czarnobyl"), stacjaZrodlowa, stacjaDocelowa, 10, 400000, 4, 30);
        List<StacjaKolejowa> stacjePosrednie = new ArrayList<>();
        Stack<StacjaKolejowa> stosOdwiedzonychStacji = new Stack<>();

        for (int i = 1; i < stacje.size() - 1; i++) {
            stacjePosrednie.add(stacje.get(i));
        }
        Pociag pociag = new Pociag(lokomotywa, stacjaZrodlowa, stacjaDocelowa, stacjePosrednie);

        WagonPasazerski wagonPasazerski = new WagonPasazerski(10000, 12000);
        wagonPasazerski.dodajPasazerow(20);
        WagonPasazerski wagonPasazerski1 = new WagonPasazerski(10000, 12000);
        wagonPasazerski1.dodajPasazerow(20);
        WagonPasazerski wagonPasazerski2 = new WagonPasazerski(10000, 12000);
        wagonPasazerski2.dodajPasazerow(20);
        WagonPasazerski wagonPasazerski3 = new WagonPasazerski(10000, 12000);
        wagonPasazerski3.dodajPasazerow(20);
        pociag.dodajWagon(wagonPasazerski);
        pociag.dodajWagon(wagonPasazerski1);
        pociag.dodajWagon(wagonPasazerski3);


        System.out.println("pociag");

        Thread thread = new Thread(pociag);
        thread.start();


//        while (true) {
//            System.out.println("Menu:");
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

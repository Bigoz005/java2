package com.company;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {

    public static void main(String[] args) {

        // odczytanie z pliku
        ReadFile odczyt = new ReadFile();
        String json = odczyt.odczyt();

        Gson gson = new Gson();

        // tworzenie tokenu, zeby zadbac o zgodnosc typow przy deserializacji
        Type hMapType = new TypeToken<HashMap<String, List<String>>>() {
        }.getType();

        Map<String, List<String>> hmapPolEng = new HashMap<String, List<String>>();

        // deserializacja
        hmapPolEng = gson.fromJson(json, hMapType);

        // wyluskanie kluczy i zapis do tablicy
        Set<String> klucze = hmapPolEng.keySet();
        String[] tabKlucze = new String[10];
        klucze.toArray(tabKlucze);
        List<String> listaKlucze = new ArrayList<>();

        for (int i = 0; i < tabKlucze.length; i++) {
            listaKlucze.add(tabKlucze[i]);
        }

        Random losowanie = new Random();
        Scanner in = new Scanner(System.in);

        Map<String, String> pytanieOdpowiedz = new LinkedHashMap<>();

        int liczbaLosowan = 10;
        int liczbaPoprawnychOdpowiedzi = 0;

        System.out.println("podaj imie: ");
        String imie = in.nextLine();
        System.out.println("podaj nazwisko: ");
        String nazwisko = in.nextLine();

        System.out.println("******* Test START *******");
        System.out.println();
        long startTime = System.nanoTime();

        // wlasciwy test
        for (int i = 0; i < 5; i++) {
            // losowanie slowka
            int index = losowanie.nextInt(liczbaLosowan);
            System.out.println("podaj angielskie tlumaczenie: " + listaKlucze.get(index));
            String odpowiedz = in.nextLine();

            // zapisanie do mapy zadanych pytan i udzielonych odpowiedzi
            pytanieOdpowiedz.put(listaKlucze.get(index), odpowiedz);

            // zamieniamy wszystko co wprowadzil uzytkownik na male znaki
            odpowiedz = odpowiedz.toLowerCase();

            // sprawdzanie czy odpwoiedz jest w slowniku
            for (String tlumaczenie : hmapPolEng.get(listaKlucze.get(index))) {
                if (odpowiedz.equals(tlumaczenie)) {
                    liczbaPoprawnychOdpowiedzi += 1;
                }
            }
            // usuniecie zadanego pytania (klucza)
            listaKlucze.remove(index);
            // zmniejszenie liczby losowan zeby nie wyjsc poza zakres listaKlucze
            liczbaLosowan -= 1;
        }
        long endTime = System.nanoTime() - startTime;

        // zamiana na sekundy
        double endTimeSekundy = (double) endTime / 1000000000;

        // serializacja mapy pytanieOdpowiedz
        Type pytanieOdpowiedzType = new TypeToken<HashMap<String, String>>() {
        }.getType();
        String pytanieOdpowiedzJson = gson.toJson(pytanieOdpowiedz, pytanieOdpowiedzType);
        // zapisywanie odpowiedzi do pliku
        WriteFile zapis = new WriteFile();
        System.out.println();
        System.out.println("Trwa zapisywanie do pliku....");
        zapis.zapis(pytanieOdpowiedzJson, imie, nazwisko);

        System.out.println();
        System.out.println("liczba poprawnych odpowiedzi: " + liczbaPoprawnychOdpowiedzi);
        System.out.println();
        System.out.println(String.format("czas testu: %.2f", endTimeSekundy));

        in.close();
    }
}

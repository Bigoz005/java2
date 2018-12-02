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
import javax.swing.*;
import java.awt.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {

    public static void main(String[] args) {

        //stworzenie okna
        JLabel[][] label = createWindow();

        // odczytanie z pliku
        ReadFile odczyt = new ReadFile();
        String json = odczyt.odczyt();

        Gson gson = new Gson();

        // tworzenie tokena typu, zeby zadbac o zgodnosc typow przy deserializacji
        Type hMapType = new TypeToken<HashMap<String, List<String>>>() {
        }.getType();

        Map<String, List<String>> hmapPolEng;

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
        double liczbaPunktow = 0;

        String imie = in.nextLine();
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
                    if (Levenstein(odpowiedz, tlumaczenie) == 0) {
                        liczbaPunktow += 1;
                    }
                } else if (Levenstein(odpowiedz, tlumaczenie) == 1) {
                    liczbaPunktow += 0.5;
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
        System.out.println("liczba punktów: " + liczbaPunktow);
        System.out.println();
        System.out.println(String.format("czas testu: %.2f", endTimeSekundy));

        in.close();
    }

    static double Levenstein(String s1, String s2) {
        int i, j, m, n, cost;
        int d[][];

        m = s1.length();
        n = s2.length();

        d = new int[m + 1][n + 1];

        for (i = 0; i <= m; i++)
            d[i][0] = i;
        for (j = 1; j <= n; j++)
            d[0][j] = j;

        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    cost = 0;
                else
                    cost = 1;

                d[i][j] = Math.min(d[i - 1][j] + 1,         /* remove */
                        Math.min(d[i][j - 1] + 1,         /* insert */
                                d[i - 1][j - 1] + cost));         /* change */
            }
        }

        return d[m][n];
    }

    private static JLabel[][] createWindow() {
        JFrame frame = new JFrame("Test Angielski");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(300, 200);
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        JPanel panel = new JPanel();
        panel.setSize(300, 200);
        GridLayout layout = new GridLayout(6, 3);

        JLabel[][] labels = new JLabel[5][2];
        for(int i=0; i<5; i++) {
            for(int j=0; j<2; j++) {
                labels[i][j] = new JLabel();
            }
        }

        panel.add(new JLabel("")); //00
        panel.add(new JLabel("Ang")); //01
        panel.add(new JLabel("Pol"));//02

        panel.add(new JLabel("1."));//10
        panel.add(labels[0][0]);//11
        panel.add(labels[0][1]);//12

        panel.add(new JLabel("2."));//20
        panel.add(labels[1][0]);//21
        panel.add(labels[1][1]);//22

        panel.add(new JLabel("3."));//30
        panel.add(labels[2][0]);//31
        panel.add(labels[2][1]);//32

        panel.add(new JLabel("4."));//40
        panel.add(labels[3][0]);//41
        panel.add(labels[3][1]);//42

        panel.add(new JLabel("5."));//50
        panel.add(labels[4][0]);//51
        panel.add(labels[4][1]);//52

        panel.setLayout(layout);
        frame.add(panel);


        frame.setVisible(true);
        return labels;
    }
}

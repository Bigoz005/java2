package com.company;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.swing.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main extends JPanel {

    public static void main(String[] args) {

        /*
        JFrame obj = new JFrame();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        obj.setLocation(dim.width/2-obj.getSize().width/2, dim.height/2-obj.getSize().height/2);
        obj.setBounds(10,10,710,632);
        obj.setResizable(true);;
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);;
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        String inputString =JOptionPane.showInputDialog(null,"Input a number to display");
        int input = Integer.parseInt(inputString);

        JOptionPane.showMessageDialog(null,"User entered: " + input);
        */
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

        Map<String, String> pytanieOdpowiedz = new LinkedHashMap<>();

        int liczbaLosowan = 10;
        double liczbaPunktow = 0;
        String imie = JOptionPane.showInputDialog(null, "Podaj  imie: ");
        String nazwisko = JOptionPane.showInputDialog(null, "Podaj nazwisko: ");

        JOptionPane.showMessageDialog(null, "TEST START ");
        System.out.println();
        long startTime = System.nanoTime();

        // wlasciwy test
        for (int i = 0; i < 5; i++) {

            // losowanie slowka
            int index = losowanie.nextInt(liczbaLosowan);
            String odpowiedz = JOptionPane.showInputDialog(null, "Podaj angielskie tlumaczenie: " + listaKlucze.get(index));

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

        zapis.zapis(pytanieOdpowiedzJson, imie, nazwisko);

        System.out.println();
        JOptionPane.showMessageDialog(null, String.format("liczba punktów: " + liczbaPunktow + "\nczas testu: %.2f", endTimeSekundy));

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
}

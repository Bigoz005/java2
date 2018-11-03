package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;

public class Wyscig implements Runnable {

    private Log my_log = new Log("log.txt");

    private CountDownLatch licznik;

    Wyscig(CountDownLatch licznik) {
        this.licznik = licznik;
    }

    private ArrayList<String> listNazwisko = CzytanieURL.odczytNazwisk();

    private HashMap<Integer, String> czasNazwisko = new HashMap<>();

    private Queue<Integer> kolejkaCzasy = new PriorityQueue<>(15);

    private int pierwszy = 400;
    private int drugi = 401;
    private int trzeci = 402;
    private int iteratorWyswietlania = 0;

    private int losowanieCzasu() {
        int czas;
        Random r = new Random();
        czas = (int) (r.nextGaussian() * 40 + 300);

        if (czas < 250)
            czas = 250;
        if (czas > 370)
            czas = 370;

        return czas;
    }

    private String losowanieNazwiska() {
        Random random = new Random();
        int rozmiar = listNazwisko.size();
        int index = random.nextInt(rozmiar);
        String nazwisko = listNazwisko.get(index);
        listNazwisko.remove(index);
        return nazwisko;
    }

    @Override
    public void run() {

        String nazwisko = losowanieNazwiska();
        int czas = losowanieCzasu();

        kolejkaCzasy.add(czas);

        if (czasNazwisko.isEmpty())
            czasNazwisko.put(czas, nazwisko);
        else {
            // dodaje do tego samego klucza(czasu) kolejne nazwisko, jesli czasy sie powtarzaja
            if (czasNazwisko.containsKey(czas)) {
                String staraWartosc = czasNazwisko.get(czas);
                czasNazwisko.replace(czas, staraWartosc + ", " + nazwisko);
            } else
                czasNazwisko.put(czas, nazwisko);
        }

        //pobranie i usuniecie pierwszego rekordu
        try {
            int najlepszyCzas = kolejkaCzasy.poll();

            if (najlepszyCzas < pierwszy) {
                trzeci = drugi;
                drugi = pierwszy;
                pierwszy = najlepszyCzas;
            } else if (najlepszyCzas < drugi && najlepszyCzas > pierwszy) {
                trzeci = drugi;
                drugi = najlepszyCzas;
            } else if (najlepszyCzas < trzeci && najlepszyCzas > drugi) {
                trzeci = najlepszyCzas;
            }

            // zapis logow
            my_log.logger.setLevel(Level.FINE);
            my_log.logger.fine("Zawodnik nr " + (iteratorWyswietlania + 1) + " " + nazwisko + ": " + czas + "s");

            System.out.println("Zawodnik nr " + (iteratorWyswietlania + 1) + " " + nazwisko + ": " + czas + "s");
            System.out.println();

            switch (iteratorWyswietlania) {
                case (0): {
                    System.out.println("AKTUALNA CZOLOWKA:");
                    System.out.println("1 -> " + pierwszy + "s " + czasNazwisko.get(pierwszy));
                    System.out.println();
                    break;
                }
                case (1): {
                    System.out.println("AKTUALNA KLASYFIKACJA:");
                    System.out.println("1 -> " + pierwszy + "s " + czasNazwisko.get(pierwszy));
                    System.out.println("2 -> " + drugi + "s " + czasNazwisko.get(drugi));
                    System.out.println();
                    break;
                }
                default:
                    System.out.println("AKTUALNA KLASYFIKACJA:");
                    System.out.println("1 -> " + pierwszy + "s " + czasNazwisko.get(pierwszy));
                    System.out.println("2 -> " + drugi + "s " + czasNazwisko.get(drugi));
                    System.out.println("3 -> " + trzeci + "s " + czasNazwisko.get(trzeci));
                    System.out.println();
            }
            iteratorWyswietlania += 1;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        // jak bedzie zero to odpala Killera
        this.licznik.countDown();
    }
}

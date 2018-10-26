package com.company;

import java.net.*;
import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Timer;

public class Main {

    public static void main(String[] args) throws Exception {
        URL link = new URL("http://szgrabowski.kis.p.lodz.pl/zpo18/nazwiska.txt ");

        BufferedReader in = null;
        in = new BufferedReader(new InputStreamReader(link.openStream()));

        int totalLines = 0; // zapisanie ilosci wszystkich liń
        while ((in.readLine()) != null) {
            totalLines++;
        }

        in.close();

        in = new BufferedReader(new InputStreamReader(link.openStream()));

        String[] nazwiska = new String[totalLines];
        for (int i = 0; i < totalLines; i++) {
            nazwiska[i] = in.readLine();
        }

        Set<String> competitors = new HashSet<String>();

        String linia;
        int count = 0;
        Random random = new Random();
        int randomInt;

        while (competitors.size() < 15) {
            randomInt = random.nextInt(totalLines);
            linia = nazwiska[randomInt];
            competitors.add((String) (linia));
            count++;
        }
        in.close();

        System.out.println("Uczestnikow: " + count);
        System.out.println(competitors);

        Timer timer = new Timer();
        int sec = (int) (random.nextGaussian() * 40 + 300);
        System.out.println(sec);
        //1s rzeczywsta = 25s symulacji
        if (sec < 250) {
            sec = 250;
        }
        if (sec > 370) {
            sec = 370;
        }
        System.out.println(sec);
    }
}

/*
http://szgrabowski.kis.p.lodz.pl/zpo18/lab03.pdf
https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
https://codereview.stackexchange.com/questions/85429/picking-random-lines-out-of-text-files
https://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html
 */

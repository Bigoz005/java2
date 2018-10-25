package com.company;

import java.net.*;
import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = null;

        URL nazwiska = new URL("http://szgrabowski.kis.p.lodz.pl/zpo18/nazwiska.txt ");
        in = new BufferedReader(new InputStreamReader(nazwiska.openStream()));

        int totalLines = 0;
        while ((in.readLine()) != null) {
            totalLines++;
        }
        in.close();
        System.out.println("elo");
        in = new BufferedReader(new InputStreamReader(nazwiska.openStream()));

        Random random = new Random();
        int randomInt = random.nextInt(totalLines);
        int count = 0;

        Set<String> competitors = new HashSet<String>();

        String icaocode;

            while (competitors.size() < 15) {
                icaocode = in.readLine();
                if (count == randomInt) {
                    System.out.println("elo");
                    competitors.add((String) (icaocode));
                }
                count++;
            }


        System.out.print(competitors);
        in.close();

    }
}

/*
http://szgrabowski.kis.p.lodz.pl/zpo18/lab03.pdf
https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
https://codereview.stackexchange.com/questions/85429/picking-random-lines-out-of-text-files
https://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html
 */

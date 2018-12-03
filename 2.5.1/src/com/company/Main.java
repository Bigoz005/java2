package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Stream;

public class Main {

    interface Person {
        int processPerson(String str1, String str2);
    }

    public static void main(String[] args) {

        ArrayList<String[]> peopleSplit = new ArrayList();

        LinkedHashMap<String, Integer> nationalities = new LinkedHashMap<>(4);

        int max1 = 0, max2 = 0;
        int maxIndex1 = 0, maxIndex2 = 0;
        int min1 = 0, min2 = 0;
        int minIndex1 = 0, minIndex2 = 0;
        //lambda
        Person suma = (str1, str2) -> (Integer.parseInt(str1) + Integer.parseInt(str2));

        String file = "C://Users//micha//IdeaProjects//2.5.1//dane.txt";
        try (Stream<String> stream = Files.lines(Paths.get(file), StandardCharsets.ISO_8859_1)) {
            stream.peek(e -> {                          //podejrzenie strumienia
                String[] test = e.split(" ");
                peopleSplit.add(test);                  //dodanie do ArrayList
            }).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //dodaj informacje o nacjach
        for (int i = 0; i < peopleSplit.size(); i++) {
            if (nationalities.containsKey(peopleSplit.get(i)[2])) {
                nationalities.replace(peopleSplit.get(i)[2], (nationalities.get(peopleSplit.get(i)[2]) + 1));
            } else {
                nationalities.put(peopleSplit.get(i)[2], 1);
            }
            if (peopleSplit.get(i)[2].equalsIgnoreCase("PL")) {
                if (Integer.parseInt(peopleSplit.get(i)[3]) > max1) {
                    max2 = max1;
                    maxIndex2 = maxIndex1;
                    max1 = Integer.parseInt(peopleSplit.get(i)[3]);
                    maxIndex1 = i;
                } else if (Integer.parseInt(peopleSplit.get(i)[3]) > max2) {
                    max2 = Integer.parseInt(peopleSplit.get(i)[3]);
                    maxIndex2 = i;
                }
            }
        }

        //najlepiej zarabiajacy to ten co zarabia najmniej
        min1 = max2;
        minIndex1 = maxIndex2;
        min2 = max1;
        minIndex2 = maxIndex1;

        //zapis indexow najgorzej zarabiajacych
        for (int i = 0; i < peopleSplit.size(); i++) {
            if (peopleSplit.get(i)[2].equalsIgnoreCase("PL")) {
                if (Integer.parseInt(peopleSplit.get(i)[3]) < min1) {
                    min2 = min1;
                    minIndex2 = minIndex1;
                    min1 = Integer.parseInt(peopleSplit.get(i)[3]);
                    minIndex1 = i;
                } else if (Integer.parseInt(peopleSplit.get(i)[3]) < min2) {
                    min2 = Integer.parseInt(peopleSplit.get(i)[3]);
                    minIndex2 = i;
                }
            }
        }

        System.out.print("\nSuma zarobków najwięcej zarabiających polaków: ");
        System.out.println(suma.processPerson(peopleSplit.get(maxIndex1)[3], peopleSplit.get(maxIndex2)[3]));
        System.out.print("\nSuma zarobków najmnniej zarabiających polaków: ");
        System.out.println(suma.processPerson(peopleSplit.get(minIndex1)[3], peopleSplit.get(minIndex2)[3]) + "\n");

        for (String key : nationalities.keySet())
            System.out.println(key + " " + nationalities.get(key));
    }
}
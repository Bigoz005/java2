package com.company;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] correctNames = {"Agnieszka", "Darek", "Łukasz", "Órszula", "Stefania", "Ścibor", "Świętopełk", "Zyta"};
        String[] names = {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula", "Świętopełk"};
        sortStrings(Collator.getInstance(new Locale("pl", "PL")), names);
        fastSortStrings(Collator.getInstance(new Locale("pl", "PL")), names);
        fastSortStrings2(Collator.getInstance(new Locale("pl", "PL")), names);
    }

    Collator c = Collator.getInstance(new Locale("pl", "PL"));


    public static void sortStrings(Collator collator, String[] words) {
        int i, j;
        String temp;
        for (i = 1; i < words.length; i++) {
            temp = words[i];
            for (j = i - 1; j >= 0 && (collator.compare(words[j], temp) == 1); j--) {
                words[j + 1] = words[j];
            }
            words[j + 1] = temp;
        }
    }


    // z anonimowym komparatorem
    public static void fastSortStrings(Collator collator, String[] words) {

        // tez zadziala bo Collator implementuje Comparator
        // Arrays.sort(words, collator);

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return collator.compare(s1, s2);
            }
        });
    }

    // z lambda
    public static void fastSortStrings2(Collator collator, String[] words) {

        Arrays.sort(words, (String s1, String s2) -> {
            return collator.compare(s1, s2);
        });
    }
}

    // z anonimowym komparatorem
    public static void fastSortStrings(Collator collator, String[] words) {

        // tez zadziala bo Collator implementuje Comparator
        // Arrays.sort(words, collator);

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return collator.compare(s1, s2);
            }
        });
    }

    // z lambda
    public static void fastSortStrings2(Collator collator, String[] words) {

        Arrays.sort(words, (String s1, String s2) -> {
            return collator.compare(s1, s2);
        });
    }
}

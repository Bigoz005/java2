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
        sortStrings(Collator.getInstance(new Locale("pl")), names);
        fastSortStrings(Collator.getInstance(new Locale("pl")), names);
        fastSortStrings2(Collator.getInstance(new Locale("pl")), names);
    }

    //do poprawy
    public static void sortStrings(Collator collator, String[] words) {
        int i;
        for (i = 1; i < words.length; i++)
        {
            String temp;
            temp = words[i];
            int j;
            for (j = i; j > 0; j--)
                if (temp.compareTo(words[j - 1]) < 0)
                    words[j] = words[j - 1];
                else
                    break;
            words[j] = temp;
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
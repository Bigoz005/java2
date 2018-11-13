package com.company;

import org.junit.Test;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.Assert.*;

public class MainTest {
    private final int repeats = 100000;
    private final String[] correctNames = {"Agnieszka", "Darek", "Łukasz", "Órszula", "Stefania", "Ścibor", "Świętopełk", "Zyta"};
    private final String[] names = {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka", "Zyta", "Órszula", "Świętopełk"};

    private Locale locale;

    @org.junit.Before
    public void setUp() throws Exception {
        locale = new Locale("pl", "PL");
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void checkSorting() throws Exception {
        String[] names1 = names.clone();
        String[] names2 = names.clone();
        String[] names3 = names.clone();

        Main.sortStrings(Collator.getInstance(locale), names1);
        Main.fastSortStrings(Collator.getInstance(locale), names2);
        Main.fastSortStrings(Collator.getInstance(locale), names3);

        System.out.println(Arrays.toString(names1));
        System.out.println(Arrays.toString(names2));
        System.out.println(Arrays.toString(names3));

        assertArrayEquals(correctNames, names1);
        assertArrayEquals(correctNames, names2);
        assertArrayEquals(correctNames, names3);
    }

    @Test
    public void sortStrings() throws Exception {
        long sortingTimeAtBeginning = System.nanoTime();
        for (int i = 0; i < repeats; i++) {
            Main.sortStrings(Collator.getInstance(locale), names.clone());
        }
        System.out.println("Czas do posortowania metodą sortStrings: " + (System.nanoTime() - sortingTimeAtBeginning) + "ns");
    }

    @Test
    public void fastSortStrings1() throws Exception {
        long sortingTimeAtBeginning = System.nanoTime();
        for (int i = 0; i < repeats; i++) {
            Main.fastSortStrings(Collator.getInstance(locale), names.clone());
        }
        System.out.println("Czas do posortowania metodą fastSortStrings: " + (System.nanoTime() - sortingTimeAtBeginning) + "ns");
    }

    @Test
    public void fastSortStrings2() throws Exception {
        long sortingTimeAtBeginning = System.nanoTime();
        for (int i = 0; i < repeats; i++) {
            Main.fastSortStrings2(Collator.getInstance(locale), names.clone());
        }
        System.out.println("Czas do posortowania metodą fastSortStrings2: " + (System.nanoTime() - sortingTimeAtBeginning) + "ns");
    }
}
package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static String SEPARATOR = " ";
    String string = "a a a b b c d e e f";


    public static void main(String[] args) {

        Map<String, Integer> counts = new HashMap<String, Integer>();

        counts.put("Value1", 1);
        counts.put("Value2", 1);
        counts.put("Value3", 1);
        counts.put("Value4", 1);
        counts.put("Value5", 1);
        System.out.println("countsContainsKey: " + counts);
        countsContainsKey(counts);
        Integer str = counts.merge("Value1", 1, Integer::sum);
        System.out.println("counts.merge: " + counts);
        countsGetNull(counts);
        System.out.println("counts.GetNull: " + counts);
        countsGetOrDefault(counts);
        System.out.println("counts.GetOrDefault: " + counts);
        countsIfAbsent(counts);
        System.out.println("counts.IfAbsent: " + counts);
    }

    public static void countsContainsKey(Map<String, Integer> counts) {

        if (counts.containsKey("Value3")) {
            Integer tmp = counts.get("Value3");
            counts.replace("Value3", tmp + 1);
        }
    }

    public static void countsGetNull(Map<String, Integer> counts) {
        if (counts.get("Value4") != null) {
            Integer tmp = counts.get("Value4");
            counts.replace("Value4", tmp + 1);
        }
    }

    public static void countsGetOrDefault(Map<String, Integer> counts) {
        Integer tmp = counts.getOrDefault("Value5", 0);
        counts.replace("Value5", tmp + 1);
    }

    public static void countsIfAbsent(Map<String, Integer> counts) {
        Integer tmp = counts.get("Value2");
        counts.putIfAbsent("Value2", 1);
    }

}


/*
V oldValue = map.get(key);
 V newValue = (oldValue == null) ? value :
              remappingFunction.apply(oldValue, value);
 if (newValue == null)
     map.remove(key);
 else
     map.put(key, newValue);
 */

/*
 Dany jest słownik "counts" liczników wystąpień stringów (np. słów
w tekście). Można go uaktualnić (zwiększyć licznik dla elementu "word" o 1) w
następujący sposób:
 counts.merge(word, 1, Integer::sum);
 ( przeczytaj https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#merge-K-Vjava.util.function.BiFunction-
)
Wykonaj to samo bez użycia metody merge na 4 sposoby:
a) z użyciem metody containsKey,
b) z użyciem metody get oraz sprawdzania null-a,
c) z użyciem getOrDefault,
d) z użyciem putIfAbsent.
 */

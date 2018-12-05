package com.company;

import com.google.common.collect.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Double> list = new ArrayList<Double>();

        for (double i = 0; i < 4; i += 0.001) {
            list.add(i);
        }

        System.out.println(list);

        List<Double> transform = Lists.transform(list, Main::f1); //The function is applied lazily, invoked when needed. [...]To avoid lazy evaluation when the returned list doesn't need to be a view, copy the returned list into a new list of your choosing.

        System.out.println("Od przodu: " + transform);
        List<Double> reversedList=new ArrayList<>();

        reversedList = Lists.reverse(transform);

        System.out.println("Od tylu: " + reversedList);
        int idx = Collections.binarySearch(transform, 0.0);
        //Punkt wstawienia jest definiowany jako punkt, w którym klucz zostanie wstawiony do listy:
        //indeks pierwszego elementu większego niż klucz lub list.size (), jeśli wszystkie elementy na liście są mniejsze niż określony klucz.
        System.out.println("IDX: " + idx);
        System.out.println("IDX: " + list.get(-idx));

    }

    public static double f1(double x) {
        return Math.pow(x, 2) - 4;
    }

}
//https://google.github.io/guava/releases/22.0/api/docs/com/google/common/collect/Lists.html
//https://github.com/google/guava/issues/350
//https://stackoverflow.com/questions/22719783/guava-lazy-collection-using-supplier-interface

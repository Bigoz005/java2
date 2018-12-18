package com.company;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Bisection {

    static final float EPSILON = (float)0.001;

    double func(double x)
    {
        //return x*x*x - x*x + 2;
        return 4*x+3;
        //return x*x*x - x*x + 2;
        //return -4*x*x*x+12;
    }

    void bisection(double a, double b)
    {

        List<Double> point = new LinkedList<>(); //x
        List<Double> value; //y

        point.add(a);
        point.add(b);


        value = Lists.transform(point,this::func); //lista leniwa, punkt wrzucany jest do funkcji i zapisywany w value

        if (value.get(0) * value.get(1) >= 0)
        {
            System.out.println("Podales niepoprawny zakres, podaj nowy.");
            return;
        }

        double mid = a;
        while(mid<EPSILON)
        {
            // dopóki nie uzyskamy zadanej dokładności dzielimy przedzial na pol
            mid = (point.get(0)+point.get(1))/2;

            // jeżeli znaleźliśmy miejsce zerowe mniejsze bądź równe przybliżeniu zera
            if (func(mid) == 0.0) break;

            if (func(mid)*value.get(0) < 0)
                point.set(1,mid); //nadpisywanie prawego krańca przedziału
            else
                point.set(0,mid); //nadpisywanie lewego krańca przedziału
        }

        Collections.binarySearch(value,0.0, (Comparator<Number>)(v1, v2)->{
            if(Math.abs((Double)v1) <= (Double)v2 + EPSILON) return 0;
            return -1;
        });

        System.out.println(mid);
    }

}

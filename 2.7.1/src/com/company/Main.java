package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static Double f(Double x){
        return x+2*x-3;
    }

    static class bisectList extends ArrayList<Double> { //klasa rozszerzajaca arraylist
        bisectList(double a, double b, double eps){
            for(int i=0;i<=Math.abs(a-b)/eps;i++){
                this.add(i*eps+a);
            }
        }
        @Override
        public Double get(int index)                    //przeciazenie get'a
        {
            return f(super.get(index));
        }
    }

    public static void main(String[] args) {
        double a = -4, b=0,eps=0.1;
        int zero;

        ArrayList<Double> list= new bisectList(a,b,eps);
        if(f(a)<f(b))
            zero = Collections.binarySearch(list,0.0);
        else
            zero = Collections.binarySearch(list,0.0,Collections.reverseOrder());

        if(zero<0)
            System.out.println("nie znaleziono miejsca zerowego w przedziale");
        else
            System.out.println("y=0 dla x= "+ (a+zero*eps));

    }
}

package com.company;
import java.util.ArrayList;

public class MaxSearchAlgorithms {

    ArrayList<Integer> maxLewoPrawoScan(int[] tab)
    {
        ArrayList<Integer> result = new ArrayList<>(tab.length);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<tab.length; i++)
        {
            if(max < tab[i]){
                result.add(tab[i]);
                max = tab[i];
            }
        }
        return result;
    }

    ArrayList<Integer> maxPrawoLewoScan(int[] tab)
    {
        ArrayList<Integer> result = new ArrayList<>(tab.length);
        int max = Integer.MIN_VALUE;
        for(int i=tab.length-1; i>0; i--)
        {
            if(max < tab[i]){
                result.add(tab[i]);
                max = tab[i];
            }
        }
        return result;
    }

    ArrayList<Integer> maxParzysteNieparzysteScan(int[] tab)
    {
        ArrayList<Integer> result = new ArrayList<>(tab.length);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<tab.length; i+=2)
        {
            if(max < tab[i]){
                result.add(tab[i]);
                max = tab[i];
            }
        }
        for(int i=1; i<tab.length; i+=2)
        {
            if(max < tab[i]){
                result.add(tab[i]);
                max = tab[i];
            }
        }
        return result;
    }

}
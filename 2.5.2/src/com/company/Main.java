package com.company;

import java.util.HashMap;

public class Main {

    //jesli w danej mapie jest taki key, ktorego potrzebujemy - zwraca true, jesli go nie znajdzie - false
    public static void containsKey(HashMap<String, Integer> map, String key, Integer value){
        if(map.containsKey(key)){
            map.replace(key,map.get(key)+value);
        }else{
            map.put(key,value);
        }
    }

    //jesli nie znajdziemy danego key w mapie szuakajac tą metodą - dostaniemy null
    public static void get(HashMap<String, Integer> map, String key, Integer value){
        if(map.get(key)!= null){
            map.replace(key,map.get(key)+value);
        }else{
            map.put(key,value);
        }
    }

    //zwraca wartosc klucza jesli go znajdzie, jesli nie znajdzie klucza - zwraca wartosc, ktora sobie ustalimy
    public static void getOrDefault(HashMap<String, Integer> map, String key, Integer value){
        if(map.getOrDefault(key,0) != 0){
            map.replace(key,map.get(key)+value);
        }else{
            map.put(key, value);
        }
    }

    //jesli szukanego klucza nie ma w mapie, to zostaje dodany, a jesli sie juz ten klucz znajduje - to nic nie robi
    public static void pullIfAbsent(HashMap<String, Integer> map, String key, Integer value){
        if(map.putIfAbsent(key,value)!= null){
            map.replace(key,map.get(key)+value);
        }
    }

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        String key = "word";
        Integer value = 1;

        map.put(key,value);
        map.merge(key,value,Integer::sum);
        System.out.println(map);
    }
}
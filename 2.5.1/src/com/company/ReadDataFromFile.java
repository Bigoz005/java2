package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadDataFromFile {

    public static void worstEarners(){

        try (Stream<String> stream = new BufferedReader(new FileReader("dane.txt")).lines()) {

            System.out.println("Najgorzej: "+stream.filter(f -> f.contains("PL"))
                    .mapToInt(f -> Integer.parseInt(f.split(" ",4)[3]))
                    .sorted()
                    .limit(2)
                    .sum());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void bestEarners(){

        try(Stream<String> stream = new BufferedReader(new FileReader("dane.txt")).lines()){


            System.out.println("Najlepiej: " + stream.filter(f -> f.contains("PL"))
                    .mapToInt(f -> Integer.parseInt(f.split(" ", 4)[3]))
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .limit(2)
                    .collect(Collectors.summarizingInt(Integer::intValue))
                    .getSum());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void countEarnersByCountry(){

        try(Stream<String> stream = new BufferedReader(new FileReader("dane.txt")).lines()){


            stream.collect(Collectors.groupingBy(f -> f.split(" ",4)[2], LinkedHashMap::new, Collectors.toList())).forEach((v,k)-> System.out.println(v+"->"+k.size()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            RandomNumbers test = new RandomNumbers(10000, 0, 1);
            test.closeDataStreams();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
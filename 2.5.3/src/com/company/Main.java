package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wprowadz liczbe dni dla ktorych chcesz wykonac symulację procesu nauki Janka: ");
        int number = input.nextInt();
        EnglishWordsLearning learning = new EnglishWordsLearning();
        learning.printLearing(number);
    }
}
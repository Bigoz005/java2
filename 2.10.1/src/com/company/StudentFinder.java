package com.company;

import java.util.Scanner;

public class StudentFinder {

    public static String findStudentByIndex() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź indeks studenta, którego chcesz odnaleźć:");
        String index = "";

        while (index.length() != 6) {
            index = scanner.next();

            if (index.length() != 6) {
                System.out.println("Wprowadzony numer indeksu jest niepoprawny! Powinien posiadać 6 cyfr!");
            }
        }

        return index;
    }
}

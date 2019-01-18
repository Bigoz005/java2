package com.company;

import java.util.List;
import java.util.Scanner;

public class MarkAdder {

    public static Student perform(List<Integer> possibleMarks, Student student) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("== Czy chcesz wprowadzić studentowi ocenę? 1 - TAK / 0 - NIE ==");

        int decision = scanner.nextInt();
        if (decision == 1) {
            System.out.print("Wprowadź ocenę studentowi (2, 3, 4, 5): ");
            int mark = scanner.nextInt();

            if (!possibleMarks.contains(mark)) {
                System.out.println("Wprowadzono złą ocenę!");
            } else {
                student.addMark(mark);
            }
        }

        return student;
    }
}

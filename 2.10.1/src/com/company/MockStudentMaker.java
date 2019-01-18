package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class MockStudentMaker {

    public static Student[] perform() {
        Student[] students = new Student[5];

        students[0] = new Student("Michał", "AAAAAA", "209405", new ArrayList<>(Arrays.asList(5, 5, 4, 3, 5)));
        students[1] = new Student("BBBBBBBBB", "BBBBBB", "222222", new ArrayList<>(Arrays.asList(4, 4, 5, 5, 3)));
        students[2] = new Student("CC", "CCCCC", "333333", new ArrayList<>(Arrays.asList(4, 3, 5, 5, 3)));
        students[3] = new Student("DDDDD", "DDDDDD", "444444", new ArrayList<>(Arrays.asList(5, 5, 5, 4, 5)));
        students[4] = new Student("EEEEEE", "EEEEEE", "555555", new ArrayList<>(Arrays.asList(3, 3, 5, 5, 4)));

        return students;
    }

    public static void printListOfStudents(Student[] students) {
        for (Student student: students) {
            System.out.println(student);
        }
    }
}

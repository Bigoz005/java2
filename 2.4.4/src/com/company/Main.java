package com.company;

public class Main {
        public static void main(String[] args) {
            SortStudents sortStudents = new SortStudents();
            sortStudents.sortUsingMyComparator();
            sortStudents.sortUsingGuava();
        }
}
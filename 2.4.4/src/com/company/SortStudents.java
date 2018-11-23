package com.company;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ComparisonChain;

public class SortStudents {
    private List<Student> students;

    public SortStudents() {
        this.students = new ArrayList<>();
        students.add(new Student("Krzysztof", "Nowak", 1995, 180));
        students.add(new Student("Sebastian", "Nowacki", 1995, 175));
        students.add(new Student("Waldemar", "Fornalik", 1982, 172));
        students.add(new Student("Ignacy", "Fanta", 1995, 185));
        students.add(new Student("Szymon", "Nalepa", 1994, 183));
        students.add(new Student("Adam", "Falda", 1995, 178));
    }

    public void sortUsingMyComparator() {
        System.out.println("Using my Comparator: ");
        MyComparator myComparator = new MyComparator();
        students.sort(myComparator);
        for(Object o : students)
            System.out.println(o.toString());
        System.out.println();
    }

    public void mixStudents() {
        students.clear();
        students.add(new Student("Szymon", "Nalepa", 1994, 183));
        students.add(new Student("Adam", "Falda", 1995, 178));
        students.add(new Student("Sebastian", "Nowacki", 1995, 175));
        students.add(new Student("Krzysztof", "Nowak", 1995, 180));
        students.add(new Student("Ignacy", "Fanta", 1995, 185));
        students.add(new Student("Waldemar", "Fornalik", 1982, 172));
    }

    public void sortUsingGuava() {
        System.out.println("Using Guava: ");
        mixStudents();
        students.sort(Student::compareTo);
        for(Object o : students)
            System.out.println(o.toString());
    }
}
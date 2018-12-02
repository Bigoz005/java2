package com.company;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

import java.util.Comparator;

public class Student implements Comparable<Student> {

    private String name;
    private String surname;
    private int dateOfBirth;
    private int height;

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public int getHeight() {
        return height;
    }

    public Student(String name, String surname, int dateOfBirth, int height) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
    }

    @Override
    public int compareTo(Student o) {
        if (this.getDateOfBirth() != o.getDateOfBirth()) { //jezeli rozna data to posortuj
            return ComparisonChain.start()
                    .compare(this.getDateOfBirth(), o.getDateOfBirth())
                    .result();
        } else if (this.getSurname().charAt(0) != o.getSurname().charAt(0)) { //jezeli pierwsza litera inna to posortuj po nazwisku
            return ComparisonChain.start()
                    .compare(this.getSurname().charAt(0), o.getSurname().charAt(0))
                    .result();
        } else
            return ComparisonChain.start()
                    .compare(this.getHeight(), o.getHeight(), Ordering.natural().reverse()) // jezeli data ta sama i litera ta sama to sortuj po wysokosci
                    .result();
    }

    @Override
    public String toString() {
        return "Imie: " + getName() + ", Nazwisko: " + getSurname() + ", Rok urodzenia: " + getDateOfBirth() + ", Wzrost: " + getHeight();
    }
}
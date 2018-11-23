package com.company;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private int dateOfBirth;
    private int height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Student(String name, String surname, int dateOfBirth, int height) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
    }

    @Override
    public int compareTo(Student s) {
        return ComparisonChain.start()
                .compare(dateOfBirth, s.dateOfBirth, Ordering.natural().reverse())
                .compare(surname, s.surname)
                .compare(height, s.height)
                .result();
    }

    @Override
    public String toString() {
        return "Imie: " + getName() + ", Nazwisko: " + getSurname() + ", Rok urodzenia: " + getDateOfBirth() + ", Wzrost: " + getHeight();
    }
}
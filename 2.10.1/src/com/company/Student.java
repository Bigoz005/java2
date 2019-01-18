package com.company;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {

    private String firstName;
    private String lastName;
    private String index;
    private List<Integer> marks;

    public Student(String firstName, String lastName, String index, List<Integer> marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.index = index;
        this.marks = marks;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public void addMark(int mark) {
        this.marks.add(mark);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", index=" + index +
                ", marks=" + marks +
                '}';
    }
}

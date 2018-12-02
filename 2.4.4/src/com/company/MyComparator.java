package com.company;
import java.util.Comparator;

public class MyComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        if(s1.getDateOfBirth() > s2.getDateOfBirth()) return 1;
        else if(s1.getDateOfBirth() == s2.getDateOfBirth()) {
            if(s1.getSurname().charAt(0) > s2.getSurname().charAt(0)) return 1;
            else if(s1.getSurname().charAt(0) == s2.getSurname().charAt(0)) {
                if(s1.getHeight() < s2.getHeight()) return 1;
                else return -1;
            }
            else return -1;
        }
        else return -1;
    }
}
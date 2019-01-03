package com.company;

public class Main {

    public static void main(String[] args) {
        Employee patryk = new Employee(1, "Patryk", 3500.0, true);
        Employee bartek = new Employee(1, "Patryk", 3500.0, true);

        EmployeeWithAdnotation kasia = new EmployeeWithAdnotation(4, "Kasia", 3500.50, false);
        EmployeeWithAdnotation kasia2 = new EmployeeWithAdnotation(4, "Kasia", 3500.50, false);

        System.out.println(kasia.equals(kasia2));
        System.out.println(patryk.equals(bartek));
    }
}

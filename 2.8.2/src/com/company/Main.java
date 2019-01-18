package com.company;

public class Main {

    public static void main(String[] args) {
        Employee igor1 = new Employee(1, "Igor", 3500.0, true);
        Employee igor2 = new Employee(1, "Igor", 3500.0, true);

        EmployeeWithAdnotation kasia = new EmployeeWithAdnotation(4, "Kasia", 3500.50, false);
        EmployeeWithAdnotation kasia2 = new EmployeeWithAdnotation(4, "Kasia", 3500.50, false);

        System.out.println(kasia.equals(kasia2));
        System.out.println(igor1.equals(igor2));
    }
}


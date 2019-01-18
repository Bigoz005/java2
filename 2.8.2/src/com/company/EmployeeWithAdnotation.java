package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EmployeeWithAdnotation {

    private int id;
    private String name;
    private double salary;
    private boolean gender;

    public EmployeeWithAdnotation(int id, String name, double salary, boolean gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @MyOwnCustomAdnotation
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {
        Class class2 = this.getClass();
        boolean isEqual = true;
        Method[] methods = class2.getDeclaredMethods();

        for (Method method: methods) {
            if (method.getName().startsWith("get") && method.getAnnotation(MyOwnCustomAdnotation.class) == null) {
                try {
                    if (!method.invoke(obj).equals(method.invoke(this))) {
                        isEqual = false;
                    }
                } catch (IllegalAccessException e) {
                    e.getMessage();
                } catch (InvocationTargetException e) {
                    e.getMessage();
                }
            }
        }

        return isEqual;
    }
}

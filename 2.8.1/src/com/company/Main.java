package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        int tab[] = {4, 10, 3, 7, 4, 1, 6, 2};
        final MaxSearchAlgorithms mm = MaxSearchAlgorithms.class.getConstructor().newInstance();

        System.out.println("Z refleksji");
        Class c = mm.getClass();
        for (Method method : c.getDeclaredMethods()) {
            if(method.getName().contains("Scan"))
            {
                System.out.println(method.getName() + " " + method.invoke(mm, tab));
            }
        }
    }
}
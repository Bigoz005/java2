package com.company;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Person implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        Random random = new Random();
        int sec = random.nextInt(4) + 1; //0-4 +1 = 1-5
        boolean isGoingToTheCinema = random.nextInt(19) == 10; // 1/20 = 0,05
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(isGoingToTheCinema) {
            System.out.println("Ta osoba po " + sec + " sekundach zdecydowała się pójśc do kina!");
            return true;
        }
        else {
            System.out.println("Ta osoba po " + sec + " sekundach zdecydowała się nie iść do kina... ");
            return false;
        }
    }
}
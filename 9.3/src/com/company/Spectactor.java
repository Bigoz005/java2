package com.company;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Spectactor implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        int value = new Random().nextInt(10) + 1;
        boolean isExiting = value == 1 || value == 2 || value == 3;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(isExiting) {
            System.out.println("- Widz zdecydował się opuścić salę! ");
            return true;
        } else {
            System.out.println("+ Widz zostaje! ");
            return false;
        }
    }
}
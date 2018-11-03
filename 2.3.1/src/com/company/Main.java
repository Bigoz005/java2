package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        CountDownLatch iloscZawodnikow = new CountDownLatch(15);

        Wyscig wyscig = new Wyscig(iloscZawodnikow);
        Runnable wyscigRunnable = wyscig;

        ScheduledExecutorService watek = Executors.newSingleThreadScheduledExecutor();

        Killer killer = new Killer(iloscZawodnikow, watek);
        Runnable kill = killer;

        ExecutorService watek2 = Executors.newSingleThreadExecutor();

        // uruchomienie watku z wyscigiem
        watek.scheduleAtFixedRate(wyscigRunnable, 0, 2400, TimeUnit.MILLISECONDS);
        // uruchomienie watku, ktory zabije watek z wyscigiem
        watek2.submit(kill);
    }
}

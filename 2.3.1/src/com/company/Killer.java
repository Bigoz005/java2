package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;

//zabija watek z wyscigiem po okreslonej liczbie zawodnikow

public class Killer implements Runnable {

    private CountDownLatch licznik;
    private ScheduledExecutorService watek;

    Killer(CountDownLatch licznik, ScheduledExecutorService watek) {
        this.licznik = licznik;
        this.watek = watek;
    }

    public void run() {
        try {
            //czeka az wszystko sie wykona
            licznik.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.watek.shutdownNow();
        System.out.println("KONIEC WYSCIGU");
        System.exit(0);
    }
}

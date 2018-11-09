package com.company;

import java.util.*;

public class Cyclist extends Observable implements Comparable<Cyclist> {
    static private final int delay = 1000/25;

    private int time;
    private int endTime;
    private String name;
    private Timer timer;

    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    Cyclist(String name)
    {
        this.name = name;
        time = 0;
        endTime = (int) (new Random().nextGaussian()*40+300);
        if(endTime < 250)
            endTime = 250;
        else if(endTime > 370)
            endTime = 370;
    }

    public void start()
    {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateTime();
            }
        }, 0, delay); //co sekunde symulacji
    }

    private void updateTime()
    {
        if(NotFinished())
            time++;
        else {
            setChanged();
            notifyObservers();
            timer.cancel();
        }
    }

    public boolean  NotFinished()
    {
        return time < endTime;
    }

    @Override
    public String toString()
    {
        return name + " " + time;
    }

    @Override
    public int compareTo(Cyclist o) {
        return Integer.compare(time, o.time);
    }
}

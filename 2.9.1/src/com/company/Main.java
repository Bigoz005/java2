package com.company;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.*;

public class Main {
    private static String[] strings = {"aaaa", "bb", "ccccccccccccc", "dddddd"};

    public static void main(String[] args) {
        Watki w = new Watki();
        w.func();
    }

    static class Watki{
        final Queue<Thread> activeThreads = new LinkedBlockingQueue<>();
        volatile boolean start = false;

        //unsynchronized
        public class MyThread extends Thread {
            String str;

            MyThread(String str)
            {
                this.str = str;
            }

            @Override
            public synchronized void run() {
                super.run();

                while(!start) { }//dopoki start == false, nic nie rob, gdyby nie ta linijka watek moglby zaczac wykonywac instrukcje zanim zapelnilibysmy kolejke

                for(int j = 0; j<str.length(); j++)
                {
                    while(activeThreads.peek() != this) { }//dopoki watek pierwszy w kolejce nie bedzie "soba", nic nie rob
                    synchronized (activeThreads) // synchornizacja watkow wzgledem siebie, https://www.tutorialspoint.com/java/java_thread_synchronization.htm
                    {
                        Thread t = activeThreads.poll();//zwroc i usun watek z przodu kolejki
                        if(t == null)//jesli pusta kolejka return;
                            return;
                        System.out.print(str.charAt(j));
                        if(j+1 < str.length())//jesli j+1 mniejsze od dlugosci stringa, dodaj watek do kolejki
                            activeThreads.add(t);
                    }
                }
                activeThreads.remove(this);//usun watek z kolejki jesli przeszedl przez calego stringa
            }
        }

        public void func() {
            int length = strings.length;

            for(int i=0; i<length; i++)
            {
                Thread t = new MyThread(strings[i]);//stworzenie 4 watkow, po jednym dla kazdego stringa
                activeThreads.add(t); //dodanie do watku kolejki
                t.start(); //uruchomienie watku
            }
            start = true;
        }
    }
}
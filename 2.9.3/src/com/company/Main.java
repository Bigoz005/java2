package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Callable<Boolean>> callableTasks = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            callableTasks.add(new Person());
        }

        ExecutorService executor = Executors.newFixedThreadPool(100);

        List<Future<Boolean>> futures = executor.invokeAll(callableTasks);

        List<Spectactor> spectacors = new ArrayList<>();

        for(Future future : futures) {
            try {
                if(future.get().equals(true)) spectacors.add(new Spectactor());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(spectacors.size() + "/" + callableTasks.size() + " zdecydowało się pójść do kina.");
        System.out.println();
        if(spectacors.size() < 5) {
            System.out.println("Przepraszamy, filmu nie będzie!");
            executor.shutdown();
            System.exit(1);
        }
        else {
            List<Callable<Boolean>> callables = new ArrayList<>(spectacors);
            List<Future<Boolean>> futures2 = executor.invokeAll(callables);
            for(Future future : futures2) {
                try {
                    if(future.get().equals(true)) spectacors.remove(spectacors.size()-1);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

            if(spectacors.size() >= 5) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println();
                System.out.println("Film zakończony!");
            } else {
                System.out.println();
                System.out.println("Film zostaje przerwany frajerzy, żadnych pieniędzy za bilety nie oddajemy!");
            }
        }

        executor.shutdown();
    }
}
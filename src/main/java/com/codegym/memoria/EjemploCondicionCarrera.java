package com.codegym.memoria;

public class EjemploCondicionCarrera {
    private volatile int counter = 0;

    public void runExample() {
        // Creamos 10 hilos que incrementan el counter simultáneamente
        Thread[] threads = new Thread[2];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> incrementCounter());
            threads[i].start();
        }

        // Esperamos a que todos los hilos terminen
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final counter value: " + counter);
    }

    public void incrementCounter() {
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }

    public static void main(String[] args) {
        EjemploCondicionCarrera example = new EjemploCondicionCarrera();
        example.runExample();
    }
}
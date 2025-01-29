package com.codegym.concurrencia;

public class EjemploDeadlock {
    private static final Object recursoA = new Object();
    private static final Object recursoB = new Object();

    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            synchronized (recursoA) {
                System.out.println("Hilo 1: Bloqueado recurso A");
                try {
                    Thread.sleep(100); // Simula trabajo con recurso A
                } catch (InterruptedException e) { e.printStackTrace(); }

                synchronized (recursoB) {
                    System.out.println("Hilo 1: Bloqueado recurso B");
                }
            }
        });

        Thread hilo2 = new Thread(() -> {
            synchronized (recursoB) {
                System.out.println("Hilo 2: Bloqueado recurso B");
                try {
                    Thread.sleep(100); // Simula trabajo con recurso B
                } catch (InterruptedException e) { e.printStackTrace(); }

                synchronized (recursoA) {
                    System.out.println("Hilo 2: Bloqueado recurso A");
                }
            }
        });

        hilo1.start();
        hilo2.start();
    }
}

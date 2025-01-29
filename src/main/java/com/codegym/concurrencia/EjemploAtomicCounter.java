package com.codegym.concurrencia;

import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAtomicCounter {

    private AtomicInteger valor;

    public EjemploAtomicCounter() {
        valor = new AtomicInteger(0);
    }

    public int incrementar() {
        int nuevoValor = valor.incrementAndGet();
        System.out.println(Thread.currentThread().getName() +
                " escribe: " + nuevoValor);
        return nuevoValor;
    }

    public static void main(String[] args) {
        EjemploAtomicCounter atomicCounter = new EjemploAtomicCounter();
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                int valorT1 = atomicCounter.incrementar();
                System.out.println(Thread.currentThread().getName() + " lée: "
                    + valorT1);
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                int valorT2 = atomicCounter.incrementar();
                System.out.println(Thread.currentThread().getName() + " lee: "
                    + valorT2);
            }
        });
        t1.start();
        t2.start();

        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

package com.codegym.memoria;

public class CounterExample {

    private static class Counter {
        private int value;

        public Counter() {
            value = 0;
        }

        public synchronized int increment() {
            this.value++;
            System.out.println(Thread.currentThread().getName() + " escribe: " + value);
            return value;
        }

    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t0 = new Thread(() -> {
            int valorT1 = counter.increment();
            System.out.println(Thread.currentThread().getName() + " lée: "
                    + valorT1);
        });
        Thread t1 = new Thread(() -> {
            int valorT2 = counter.increment();
            System.out.println(Thread.currentThread().getName() + " lee: "
                    + valorT2);
        });
        t0.start();
        t1.start();
        
        try {
            t1.join();
            t0.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

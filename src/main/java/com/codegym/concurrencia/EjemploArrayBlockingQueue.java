package com.codegym.concurrencia;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class EjemploArrayBlockingQueue {

    public static void main(String[] args) {
        // Creando una ArrayBlockingQueue con capacidad de 5
        BlockingQueue<Integer> colaBloqueante = new ArrayBlockingQueue<>(5);

        // Productor que añade elementos a la cola
        Runnable producer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    colaBloqueante.put(i); // Bloquea si la cola está llena
                    System.out.println("Productor agrega: " + i);
                    Thread.sleep(100); // Simular alguna latencia
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Consumidor que toma elementos de la cola
        Runnable consumer = () -> {
            try {
                while (!colaBloqueante.isEmpty()) {
                    Integer item = colaBloqueante.take(); // Bloquea si la cola está vacía
                    System.out.println("Consumidor toma: " + item);
                    Thread.sleep(3000); // Simular procesamiento
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Iniciando un hilo productor y dos consumidores
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
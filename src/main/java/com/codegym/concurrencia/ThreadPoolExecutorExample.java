package com.codegym.concurrencia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) {
        // Crear un ThreadPoolExecutor con 2 hilos y una cola de tareas ilimitada
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Enviar 5 tareas al pool de hilos
        for (int i = 1; i <= 5; i++) {
            Runnable task = new Tarea("Tarea-" + i);
            System.out.println("Enviando al pool de hilos la tarea " + task);
            executor.execute(task);
        }

        // Cerrar el executor y esperar que todas las tareas terminen
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

// Definir una tarea que se ejecutará en un hilo
class Tarea implements Runnable {
    private final String nombreTarea;

    public Tarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    @Override
    public void run() {
        System.out.println(nombreTarea + " está iniciando.");
        try {
            // Simular una tarea que tarda tiempo
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(nombreTarea + " ha terminado.");
    }

    @Override
    public String toString() {
        return nombreTarea;
    }
}
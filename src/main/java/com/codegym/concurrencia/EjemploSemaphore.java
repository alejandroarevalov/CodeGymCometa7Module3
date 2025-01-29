package com.codegym.concurrencia;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class EjemploSemaphore {

    // Creamos un semáforo con 3 permisos, es decir, 3 hilos pueden acceder al recurso al mismo tiempo.
    private static final Semaphore semaforo = new Semaphore(3);

    public static void main(String[] args) {

        // Hilos que intentarán acceder al recurso limitado
        Runnable tarea = () -> {
            try {
                // Intentamos adquirir un permiso del semáforo
                semaforo.acquire();
                System.out.println(Thread.currentThread().getName() + " ha adquirido el permiso y está trabajando.");

                // Simulamos un trabajo que toma 5 segundos
                Thread.sleep(5000);

                // El hilo libera el permiso al finalizar el trabajo
                System.out.println(Thread.currentThread().getName() + " ha terminado y ha liberado el permiso.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // Liberamos el permiso, para que otro hilo pueda acceder
                semaforo.release();
            }
        };

        // Creamos 5 hilos que intentarán acceder al recurso
        for (int i = 0; i < 5; i++) {
            new Thread(tarea, "Hilo-" + i).start();
        }
    }
}

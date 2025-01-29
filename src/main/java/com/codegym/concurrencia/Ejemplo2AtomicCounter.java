package com.codegym.concurrencia;

import java.util.concurrent.atomic.AtomicInteger;

public class Ejemplo2AtomicCounter {
    private static AtomicInteger contador = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        int numHilos = 1000;
        Thread[] hilos = new Thread[numHilos];

        // Crear y ejecutar 1000 hilos que intentan incrementar el contador
        for (int i = 0; i < numHilos; i++) {
            hilos[i] = new Thread(() -> {
                int valorActual;
                int nuevoValor;
                do {
                    valorActual = contador.get();  // Leer el valor actual
                    nuevoValor = valorActual + 1;  // Calcular nuevo valor
                } while (!contador.compareAndSet(valorActual, nuevoValor)); // Intentar actualizar
            });
            hilos[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            hilo.join();
        }

        // Mostrar el valor final del contador
        System.out.println("Valor final del contador: " + contador.get());
    }
}
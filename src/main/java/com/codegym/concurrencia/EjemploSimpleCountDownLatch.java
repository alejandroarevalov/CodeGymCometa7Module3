package com.codegym.concurrencia;

import java.util.concurrent.CountDownLatch;

public class EjemploSimpleCountDownLatch {

    public static void main(String[] args) {
        // Inicializamos el CountDownLatch con 1, ya que solo necesitamos que todos esperen una señal
        CountDownLatch startSignal = new CountDownLatch(1);

        // Creamos 3 corredores (hilos) que esperarán la señal de inicio
        for (int i = 1; i <= 3; i++) {
            new Thread(new Runner(startSignal), "Runner-" + i).start();
        }

        try {
            // Simulamos alguna preparación antes de la carrera
            System.out.println("Preparandose para la carrera...");
            Thread.sleep(3000); // Simula tiempo de preparación

            // Damos la señal de inicio
            System.out.println("La carrera empieza ahora!");
            startSignal.countDown(); // Libera a todos los corredores
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Clase Runner que espera la señal para empezar a correr
class Runner implements Runnable {
    private final CountDownLatch startSignal;

    public Runner(CountDownLatch startSignal) {
        this.startSignal = startSignal;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " está listo y en espera de la señal de inicio");
            startSignal.await(); // Espera la señal de inicio
            System.out.println(Thread.currentThread().getName() + " está corriendo!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

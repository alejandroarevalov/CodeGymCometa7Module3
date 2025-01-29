package com.codegym.concurrencia;

public class EjemploSynchronized {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        // Crear 1000 hilos, cada uno incrementa el contador 1000 veces
        Thread[] hilos = new Thread[1000];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    contador.incrementar();
                }
            });
        }

        // Iniciar todos los hilos
        for (Thread hilo : hilos) {
            hilo.start();
        }

        // Esperar a que todos terminen
        for (Thread hilo : hilos) {
            hilo.join();
        }

        // Debería ser 1,000,000 si synchronized funciona correctamente
        System.out.println("Valor final del contador: " + contador.getValor());
    }
}

class Contador {
    private int valor = 0;

    // 🔥 Método sincronizado para evitar condiciones de carrera
    public synchronized void incrementar() {
        valor++; // Sin synchronized, dos hilos podrían leer y escribir valores incorrectos
    }

    public synchronized int getValor() {
        return valor;
    }
}

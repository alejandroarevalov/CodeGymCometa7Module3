package com.codegym.concurrencia;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EjemploConcurrentHashMap {
    private static final ConcurrentHashMap<String, Integer> mapaPalabras = new ConcurrentHashMap<>();

    public static void contarPalabra(String palabra) {
        mapaPalabras.merge(palabra, 1, Integer::sum);
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4); // 4 hilos

        String[] palabras = {"java", "concurrencia", "mapa", "java", "hilos", "mapa", "java", "executor"};

        // Lanzar múltiples tareas concurrentes
        for (String palabra : palabras) {
            executor.execute(() -> contarPalabra(palabra));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Espera a que terminen los hilos
        }

        // Imprimir el resultado
        for (Map.Entry<String, Integer> entry : mapaPalabras.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
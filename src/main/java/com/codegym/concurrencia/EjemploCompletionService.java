package com.codegym.concurrencia;

import java.util.concurrent.*;

// Control sobre el orden de finalización de hilos.
public class EjemploCompletionService {

    // Tarea que suma los números de un arreglo
    public static Callable<Integer> sumaArreglo(int[] arreglo) {
        return () -> {
            int suma = 0;
            for (int num : arreglo) {
                suma += num;
            }
            return suma;
        };
    }

    public static void main(String[] args) {
        // Crea un ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Crea un CompletionService para manejar los resultados de las tareas
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);

        // Definir varios arreglos de números para sumar
        int[] arreglo1 = {1, 2, 3, 4, 5}; // 15
        int[] arreglo2 = {6, 7, 8, 9, 10}; // 40
        int[] arreglo3 = {11, 12, 13, 14, 15}; // 65

        // Enviar tareas al CompletionService
        completionService.submit(sumaArreglo(arreglo1));
        completionService.submit(sumaArreglo(arreglo2));
        completionService.submit(sumaArreglo(arreglo3));

        // Obtener resultados en el orden en que se completan
        try {
            for (int i = 0; i < 3; i++) {
                Future<Integer> result = completionService.take(); // Obtener el resultado de la tarea que haya terminado
                System.out.println("Resultado de la suma: " + result.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Apagar el executor
        executor.shutdown();
    }
}

package com.codegym.concurrencia;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public class EjemploRunnableFuture {

    public static void main(String[] args) {
        // Definimos una tarea que calcule el factorial de un número grande
        Callable<String> factorialTask = () -> {
            long numero = 25;
            Thread.sleep(5000);
            System.out.println("Iniciando cálculo del factorial");
            return factorial(numero);
        };

        // Creamos un RunnableFuture usando FutureTask
        RunnableFuture<String> runnableFuture = new FutureTask<>(factorialTask);

        // Ejecutamos la tarea en un hilo separado
        new Thread(runnableFuture).start();

        try {
            // Hacemos otras tareas mientras se calcula el factorial...
            System.out.println("Haciendo otras tareas mientras se ejecuta el resultado");

            // Obtenemos el resultado cuando esté disponible
            String result = runnableFuture.get(); // Esto se bloquea hasta que el cálculo esté completo
            System.out.println("Factorial calculado: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // Método para calcular el factorial de un número
    private static String factorial(long number) {
        BigInteger enteroGrande = BigInteger.ONE;
        for (long i = 1; i <= number; i++) {
            enteroGrande = enteroGrande.multiply(new BigInteger(""+i));
        }
        return enteroGrande.toString();
    }
}
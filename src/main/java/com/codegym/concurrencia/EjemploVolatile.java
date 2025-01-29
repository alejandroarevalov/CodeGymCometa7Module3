package com.codegym.concurrencia;

public class EjemploVolatile {
    private volatile boolean enEjecucion = true; // 🔥 Necesario para que el cambio sea visible a todos los hilos

    public void ejecutar() {
        System.out.println("Hilo de trabajo iniciado...");

        while (enEjecucion) { // 🔥 Sin volatile, este hilo podría NO ver el cambio de enEjecucion
            // Simulación de trabajo
        }

        System.out.println("Hilo de trabajo detenido.");
    }

    public void detener() {
        System.out.println("Deteniendo hilo de trabajo...");
        enEjecucion = false; // 🔥 Sin volatile, este cambio podría no ser visible para el otro hilo
    }

    public static void main(String[] args) throws InterruptedException {
        EjemploVolatile ejemplo = new EjemploVolatile();

        // Hilo que ejecuta un bucle infinito mientras enEjecucion sea true
        Thread hiloTrabajo = new Thread(ejemplo::ejecutar, "Hilo 1");
        hiloTrabajo.start();

        // Esperar 2 segundos y luego intentar detener el hilo
        Thread.sleep(2000);
        ejemplo.detener();
    }
}
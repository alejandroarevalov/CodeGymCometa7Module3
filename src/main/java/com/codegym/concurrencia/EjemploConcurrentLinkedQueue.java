package com.codegym.concurrencia;

import java.util.concurrent.ConcurrentLinkedQueue;

public class EjemploConcurrentLinkedQueue {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> cola = new ConcurrentLinkedQueue<>();

        Thread productor = new Thread(new Productor(cola));
        Thread consumidor = new Thread(new Consumidor(cola));

        productor.start();
        consumidor.start();
    }
}

class Productor implements Runnable {

    ConcurrentLinkedQueue<String> cola;
    Productor(ConcurrentLinkedQueue<String> queue){
        this.cola = queue;
    }

    public void run() {
        System.out.println("Clase para agregar itemos a la cola");
        try {
            for (int i = 1; i < 20; i++) {
                cola.add("Item #" + i);
                System.out.println("Agregado: Item #" + i);
                System.out.println("Cantidad de elementos: " + cola.size());
                Thread.sleep(300);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

class Consumidor implements Runnable {

    ConcurrentLinkedQueue<String> cola;
    Consumidor(ConcurrentLinkedQueue<String> queue){
        this.cola = queue;
    }

    public void run() {
        String str;
        System.out.println("Clase para obtener items de la cola");
        for (int x = 0; x < 20; x++) {
            while ((str = cola.poll()) != null) {
                System.out.println("Extraido: " + str);
                System.out.println("Cantidad de elementos: " + cola.size());
            }
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
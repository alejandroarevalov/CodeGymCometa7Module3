package com.codegym.patrones.singleton;

public class Impresora {
    // Instancia estática única de la impresora
    private static Impresora unicaImpresora;

    // Atributos de la impresora
    private String modelo;
    private boolean estaImprimiendo;

    // Constructor privado para evitar instanciación externa
    private Impresora() {
        this.modelo = "HP LaserJet Pro";
        this.estaImprimiendo = false;
    }

    // Método para obtener la instancia única de la impresora
    public static Impresora obtenerInstancia() {
        if (unicaImpresora == null) {
            unicaImpresora = new Impresora();
        }
        return unicaImpresora;
    }

    // Método para simular imprimir un documento
    public void imprimirDocumento(String documento) {
        if (estaImprimiendo) {
            System.out.println("La impresora está ocupada. Espere a que termine el trabajo.");
        } else {
            estaImprimiendo = true;
            System.out.println("Imprimiendo el documento: " + documento);
            // Simulamos el tiempo de impresión
            try {
                Thread.sleep(2000); // Tiempo de impresión
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            estaImprimiendo = false;
            System.out.println("Documento impreso: " + documento);
        }
    }

    // Método para obtener el modelo de la impresora
    public String obtenerModelo() {
        return modelo;
    }
}
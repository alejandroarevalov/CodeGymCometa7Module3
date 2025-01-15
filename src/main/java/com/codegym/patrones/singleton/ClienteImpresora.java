package com.codegym.patrones.singleton;

public class ClienteImpresora {
    public static void main(String[] args) {

        // Obtener la instancia única de la impresora
        Impresora impresora1 = Impresora.obtenerInstancia();

        // Imprimir documentos con la misma impresora
        impresora1.imprimirDocumento("Informe de Ventas");

        // Obtener la misma instancia de la impresora (no se crea una nueva)
        Impresora impresora2 = Impresora.obtenerInstancia();

        // Mostrar que ambas referencias apuntan al mismo objeto
        System.out.println("¿Misma impresora? " + (impresora1 == impresora2));

        // Intentar imprimir otro documento
        impresora2.imprimirDocumento("Informe de Finanzas");
    }
}

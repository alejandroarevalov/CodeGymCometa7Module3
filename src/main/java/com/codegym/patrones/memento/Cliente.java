package com.codegym.patrones.memento;

public class Cliente {
    public static void main(String[] args) {
        Documento documento = new Documento("Versión inicial del documento.");
        Cuidador cuidador = new Cuidador();

        // Guardar el estado
        System.out.println("Estado original: " + documento.getContenido());
        cuidador.guardarMemento(documento.guardarEstado());

        // Hacer modificaciones en el documento
        documento.agregarContenido(" Añadiendo más contenido.");
        System.out.println("Estado modificado: " + documento.getContenido());

        // Restaurar el estado
        documento.restaurarEstado(cuidador.obtenerMemento());
        System.out.println("Estado restaurado: " + documento.getContenido());
    }
}

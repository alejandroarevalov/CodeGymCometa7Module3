package com.codegym.patrones.memento;

// Originator
public class Documento {
    private String contenido;

    public Documento(String contenido) {
        this.contenido = contenido;
    }

    public void agregarContenido(String nuevoContenido) {
        contenido += nuevoContenido;
    }

    public String getContenido() {
        return contenido;
    }

    // Guardar el estado en un Memento
    public Memento guardarEstado() {
        return new Memento(contenido);
    }

    // Restaurar el estado desde un Memento
    public void restaurarEstado(Memento memento) {
        contenido = memento.getEstado();
    }
}

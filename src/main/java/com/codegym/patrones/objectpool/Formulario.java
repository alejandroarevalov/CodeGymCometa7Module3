package com.codegym.patrones.objectpool;

public class Formulario {
    private final int id;

    public Formulario(int id) {
        this.id = id;
    }

    public void llenar(String nombreCliente) {
        System.out.println("Formulario " + id + " siendo llenado por: " + nombreCliente);
    }

    public void reset() {
        System.out.println("Formulario " + id + " ha sido reiniciado y está listo para el próximo uso.");
    }

    @Override
    public String toString() {
        return "Formulario " + id;
    }
}
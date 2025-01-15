package com.codegym.patrones.prototype;

public class Automovil implements Prototipo {
    private String modelo;
    private String color;

    public Automovil(String modelo, String color) {
        this.modelo = modelo;
        this.color = color;
    }

    // Implementación del método clonar para crear una copia del objeto
    @Override
    public Prototipo clonar() {
        return new Automovil(this.modelo, this.color); // Clonamos el objeto creando una nueva instancia
    }

    @Override
    public String toString() {
        return "Coche{" +
            "modelo='" + modelo + '\'' +
            ", color='" + color + '\'' +
            '}';
    }
}

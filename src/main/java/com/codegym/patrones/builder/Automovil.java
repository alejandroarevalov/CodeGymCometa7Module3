package com.codegym.patrones.builder;

// La clase Producto que será el objeto complejo
public class Automovil {
    private String motor;
    private String ruedas;
    private String color;
    private String marca;
    private String modelo;

    // Getters y Setters
    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setRuedas(String ruedas) {
        this.ruedas = ruedas;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Automovil [motor=" + motor + ", ruedas=" + ruedas + ", color=" + color +
            ", marca=" + marca + ", modelo=" + modelo + "]";
    }
}
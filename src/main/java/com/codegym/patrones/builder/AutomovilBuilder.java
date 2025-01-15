package com.codegym.patrones.builder;

// Builder que define cómo construir el Automovil paso a paso
public class AutomovilBuilder {
    private String motor;
    private String ruedas;
    private String color;
    private String marca;
    private String modelo;

    public AutomovilBuilder setMotor(String motor) {
        this.motor = motor;
        return this;
    }

    public AutomovilBuilder setRuedas(String ruedas) {
        this.ruedas = ruedas;
        return this;
    }

    public AutomovilBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public AutomovilBuilder setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public AutomovilBuilder setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public Automovil build() {
        Automovil automovil = new Automovil();
        automovil.setMotor(this.motor);
        automovil.setRuedas(this.ruedas);
        automovil.setColor(this.color);
        automovil.setMarca(this.marca);
        automovil.setModelo(this.modelo);
        return automovil;
    }
}

package com.codegym.patrones.visitor;

public class Circulo implements Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitarCirculo(this);
    }
}
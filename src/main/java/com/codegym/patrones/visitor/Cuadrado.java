package com.codegym.patrones.visitor;

public class Cuadrado implements Figura {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitarCuadrado(this);
    }
}

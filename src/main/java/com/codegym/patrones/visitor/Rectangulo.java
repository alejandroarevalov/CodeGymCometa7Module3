package com.codegym.patrones.visitor;

public class Rectangulo implements Figura {
    private double ancho, alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitarRectangulo(this);
    }
}

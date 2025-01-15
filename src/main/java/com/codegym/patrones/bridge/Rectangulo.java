package com.codegym.patrones.bridge;

public class Rectangulo extends Figura {
    public Rectangulo(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.print("Dibujando un rectángulo. ");
        color.aplicarColor();
    }
}

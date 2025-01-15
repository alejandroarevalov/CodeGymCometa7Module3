package com.codegym.patrones.bridge;

public class Circulo extends Figura {
    public Circulo(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.print("Dibujando un círculo. ");
        color.aplicarColor();
    }
}

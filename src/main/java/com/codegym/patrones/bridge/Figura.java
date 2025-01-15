package com.codegym.patrones.bridge;

public abstract class Figura {
    protected Color color;

    public Figura(Color color) {
        this.color = color;
    }

    public abstract void dibujar();
}
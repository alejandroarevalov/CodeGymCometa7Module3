package com.codegym.patrones.decorator;

public class Leche extends DecoradorCafe {

    public Leche(Cafe cafeDecorado) {
        super(cafeDecorado);
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + ", Leche";
    }

    @Override
    public double getCosto() {
        return cafeDecorado.getCosto() + 1.50;
    }
}

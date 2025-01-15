package com.codegym.patrones.decorator;

public class Canela extends DecoradorCafe {
    public Canela(Cafe cafeDecorado) {
        super(cafeDecorado);
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + ", Canela";
    }

    @Override
    public double getCosto() {
        return cafeDecorado.getCosto() + 0.75;
    }
}

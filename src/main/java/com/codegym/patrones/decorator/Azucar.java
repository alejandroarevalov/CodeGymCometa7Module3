package com.codegym.patrones.decorator;

public class Azucar extends DecoradorCafe {
    public Azucar(Cafe cafeDecorado) {
        super(cafeDecorado);
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + ", Azúcar";
    }

    @Override
    public double getCosto() {
        return cafeDecorado.getCosto() + 0.50;
    }
}

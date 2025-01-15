package com.codegym.patrones.decorator;

public abstract class DecoradorCafe implements Cafe {

    protected final Cafe cafeDecorado;

    public DecoradorCafe(Cafe cafeDecorado) {
        this.cafeDecorado = cafeDecorado;
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion();
    }

    @Override
    public double getCosto() {
        return cafeDecorado.getCosto();
    }
}

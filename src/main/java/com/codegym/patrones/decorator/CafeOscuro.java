package com.codegym.patrones.decorator;

public class CafeOscuro implements Cafe {
    @Override
    public String getDescripcion() {
        return "Café oscuro";
    }

    @Override
    public double getCosto() {
        return 5.0;
    }
}

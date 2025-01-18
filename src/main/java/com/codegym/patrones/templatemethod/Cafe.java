package com.codegym.patrones.templatemethod;

public class Cafe extends Bebida {
    @Override
    protected void agregarCondimentos() {
        System.out.println("Agregando azúcar y leche...");
    }
}

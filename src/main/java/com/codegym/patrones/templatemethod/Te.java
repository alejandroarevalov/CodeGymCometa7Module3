package com.codegym.patrones.templatemethod;

public class Te extends Bebida {

    @Override
    protected void agregarCondimentos() {
        System.out.println("Agregando limón...");
    }
}

package com.codegym.patrones.templatemethod;

public abstract class Bebida {
    // Método template
    public final void prepararBebida() {
        hervirAgua();
        infusionar();
        verterEnTaza();
        agregarCondimentos();  // Este paso queda como abstracto
    }

    private void hervirAgua() {
        System.out.println("Hirviendo agua...");
    }

    // Este método es común a todas las bebidas, no lo necesitamos como abstracto
    protected void infusionar() {
        System.out.println("Infusionando...");
    }

    private void verterEnTaza() {
        System.out.println("Vertiendo en la taza...");
    }

    // Este método sí es abstracto y lo implementarán las subclases
    protected abstract void agregarCondimentos();
}

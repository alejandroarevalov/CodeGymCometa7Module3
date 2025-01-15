package com.codegym.patrones.prototype;

public class Cliente {
    public static void main(String[] args) {
        // Crear un objeto original
        Automovil automovil = new Automovil("Toyota Corolla", "Rojo");

        // Clonar el objeto
        Automovil automovilClonado = (Automovil) automovil.clonar();

        // Mostrar el objeto original y el clonado
        System.out.println("Coche original: " + automovil);
        System.out.println("Coche clonado: " + automovilClonado);
    }
}

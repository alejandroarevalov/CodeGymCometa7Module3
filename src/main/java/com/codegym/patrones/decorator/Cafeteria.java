package com.codegym.patrones.decorator;

public class Cafeteria {
    public static void main(String[] args) {
        // Café básico
        Cafe cafe = new CafeOscuro();

        // Agregar leche
        cafe = new Leche(cafe);

        // Agregar azúcar
        cafe = new Azucar(cafe);

        // Agregar canela
        cafe = new Canela(cafe);

        // Descripción y costo final
        System.out.println("Descripción: " + cafe.getDescripcion());
        System.out.println("Costo: $" + cafe.getCosto());
    }
}

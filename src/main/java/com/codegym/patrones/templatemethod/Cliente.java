package com.codegym.patrones.templatemethod;

public class Cliente {
    public static void main(String[] args) {
        Bebida cafe = new Cafe();
        System.out.println("Preparando café:");
        cafe.prepararBebida(); // Se ejecuta el algoritmo para preparar café

        System.out.println("\nPreparando té:");
        Bebida te = new Te();
        te.prepararBebida(); // Se ejecuta el algoritmo para preparar té
    }
}

package com.codegym.patrones.iterator;

public class Cliente {
    public static void main(String[] args) {
        ColeccionDeNombres coleccion = new ColeccionDeNombres();
        coleccion.agregarNombre("Ana");
        coleccion.agregarNombre("Juan");
        coleccion.agregarNombre("Pedro");

        Iterador<String> iterador = coleccion.obtenerIterador();

        System.out.println("Recorriendo la colección:");
        while (iterador.tieneSiguiente()) {
            System.out.println(iterador.siguiente());
        }
    }
}

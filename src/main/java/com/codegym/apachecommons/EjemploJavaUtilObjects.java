package com.codegym.apachecommons;

import java.util.Comparator;
import java.util.Objects;

public class EjemploJavaUtilObjects {

    public static void main(String[] args) {
        // 1. requireNonNull - Verifica que un objeto no sea null
        String nombre = null;
        try {
            // Esto evita comparación con if
            Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        } catch (NullPointerException e) {
            System.err.println("requireNonNull:");
            System.err.println(e.getMessage()); // Imprime "El nombre no puede ser nulo"
            System.err.println();
        }

        // 2. equals - Compara dos objetos de manera segura (maneja nulls)
        Persona p1 = new Persona("Alejandro", 39, "123455", true);
        Persona p2 = new Persona("Alejandro", 39, "123455", true);
        String str1 = "Hola";
        String str2 = new String("Hola");
        String str3 = null;
        System.out.println("equals:");
        System.out.println(Objects.equals(str1, str2)); // true
        System.out.println(Objects.equals(str1, str3)); // false
        System.out.println(Objects.equals(str3, null)); // true
        System.out.println("Comparando personas: " + Objects.equals(p1, p2));
        System.out.println();

        // 3. hash - Genera un hash code para un conjunto de objetos
        String direccion = "Calle 123";
        int edad = 30;
        System.out.println("hash:");
        int hashCode = Objects.hash(direccion, edad);
        System.out.println(hashCode);
        System.out.println();

        // 4. toString - Devuelve la representación en cadena de un objeto, manejando null de manera segura
        System.out.println("toString:");
        nombre = null;
        System.out.println(Objects.toString(nombre, "Desconocido")); // Imprime "Desconocido"
        nombre = "Carlos";
        System.out.println(Objects.toString(nombre, "Desconocido")); // Imprime "Carlos"
        Persona x = null;
        System.out.println(Objects.toString(x, "Valor nulo"));
        System.out.println();

        // 5. compare - Compara dos objetos utilizando un Comparator
        str1 = "Manzana";
        str2 = "Banana";
        System.out.println("compare:");
        int resultado = Objects.compare(str1, str2, Comparator.naturalOrder());
        System.out.println(resultado); // Resultado será > 0 porque "Manzana" es mayor que "Banana"
    }
}
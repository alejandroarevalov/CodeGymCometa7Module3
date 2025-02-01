package com.codegym.apachecommons;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;

public class EjemploObjectUtils {

    public static void main(String[] args) {
        String cadena = "Cadena";
        Integer numero = 33;
        Object objeto = new Object();
        String cadenaNula = null;
        Integer numeroNulo = null;
        Object objetoNulo = null;
        Persona persona = new Persona("Alejandro", 39, "Av. Siempre viva 123", true);

        // allNotNull -> Verifica si todos los objetos son distintos a null
        System.out.println("Metodo allNotNull");
        System.out.println("Todos son no nulos?: " + ObjectUtils.allNotNull(cadena, numero, objeto));
        System.out.println("Todos son no nulos?: " + ObjectUtils.allNotNull(cadena, numero, objetoNulo));
        System.out.println();

        // allNull -> Verifica si todos los objetos son nulos
        System.out.println("Metodo allNull");
        System.out.println("Todos son nulos?: " + ObjectUtils.allNull(cadenaNula, numeroNulo, objetoNulo));
        System.out.println("Todos son nulos?: " + ObjectUtils.allNull(cadenaNula, numeroNulo, objeto));
        System.out.println();

        // anyNotNull -> Verifica si existe al menos un objeto no nulo
        System.out.println("Metodo anyNotNull");
        System.out.println("Algun objecto no nulo?: " + ObjectUtils.anyNotNull(cadenaNula, numero, objetoNulo));
        System.out.println("Algun objecto no nulo?: " + ObjectUtils.anyNotNull(cadenaNula, numeroNulo, objetoNulo));
        System.out.println();

        // anyNull -> Verifica si existe al menos un objeto nulo
        System.out.println("Metodo anyNull");
        System.out.println("Algun objecto nulo?: " + ObjectUtils.anyNull(cadena, numeroNulo, objeto));
        System.out.println("Algun objecto nulo?: " + ObjectUtils.anyNull(cadena, numero, objeto));
        System.out.println();

        // clone -> Clona un objeto
        System.out.println("Metodo clone");
        Persona clon = ObjectUtils.clone(persona);
        System.out.println(clon);

    }
}

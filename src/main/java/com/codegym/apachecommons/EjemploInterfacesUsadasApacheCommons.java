package com.codegym.apachecommons;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class EjemploInterfacesUsadasApacheCommons {

    public static void main(String[] args) {
        // Ejemplo de Bag
        System.out.println("Ejemplo de Bag:");
        Bag<String> bag = new HashBag<>();
        bag.add("Manzana");
        bag.add("Banana");
        bag.add("Manzana");
        bag.add("Cereza");

        System.out.println("Conteo de 'Manzana': " + bag.getCount("Manzana")); // 2
        System.out.println("Conteo de 'Banana': " + bag.getCount("Banana")); // 1
        System.out.println("Conteo de 'Mango': " + bag.getCount("Mango")); // 0

        bag.remove("Manzana");

        System.out.println("Conteo de 'Manzana' después de eliminar: " + bag.getCount("Manzana"));

        System.out.println("Elementos en el bag:");
        for (String fruit : bag) {
            System.out.println(fruit);
        }
        System.out.println();

        // Ejemplo de BidiMap
        System.out.println("Ejemplo de BidiMap:");
        BidiMap<String, Integer> bidiMap = new DualHashBidiMap<>();
        bidiMap.put("Uno", 1);
        bidiMap.put("Dos", 2);
        bidiMap.put("Tres", 3);
        bidiMap.put("Cuatro", 3); // Sobreescritura de la clave con el mismo valor anterior

        System.out.println("Valor de 'Dos': " + bidiMap.get("Dos")); // 2
        System.out.println("Clave para valor 3: " + bidiMap.getKey(3)); // Cuatro
        System.out.println("Valor de 'Cuatro': " + bidiMap.get("Cuatro"));

        bidiMap.remove("Uno");
        System.out.println("Valor de 'Uno' después de eliminar: " + bidiMap.get("Uno")); // null
        System.out.println("Clave para valor 1 después de eliminar: " + bidiMap.getKey(1)); // null

        System.out.println("Entradas en el BidiMap:");
        for (var entry : bidiMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();
    }
}
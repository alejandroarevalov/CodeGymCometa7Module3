package com.codegym.apachecommons;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class EjemploCollectionUtils {

    public static void main(String[] args) {
        // 1. isEmpty - Verifica si una colección es vacía o null
        Collection<String> collection1 = null;
        Collection<String> collection2 = new ArrayList<>();
        Collection<String> collection3 = Arrays.asList("Uno", "Dos", "Tres");

        System.out.println("isEmpty:");
        System.out.println(CollectionUtils.isEmpty(collection1)); // true
        System.out.println(CollectionUtils.isEmpty(collection2)); // true
        System.out.println(CollectionUtils.isEmpty(collection3)); // false
        System.out.println();

        // 2. addIgnoreNull - Agrega un elemento a una colección si no es null
        Collection<String> collection4 = new ArrayList<>();
        String item = "Elemento";
        String nullItem = null;

        System.out.println("addIgnoreNull:");
        CollectionUtils.addIgnoreNull(collection4, item); // Agrega "Elemento"
        CollectionUtils.addIgnoreNull(collection4, nullItem); // No hace nada
        System.out.println(collection4); // [Elemento]
        System.out.println();

        // 3. removeAll - Elimina todos los elementos de una colección que están en otra colección
        Collection<String> collection5 = new ArrayList<>(Arrays.asList("Rojo", "Verde", "Azul"));
        Collection<String> collection6 = new ArrayList<>(Arrays.asList("Verde", "Amarillo"));

        System.out.println("removeAll:");
        Collection<String> result = CollectionUtils.removeAll(collection5, collection6);
        System.out.println(result); // [Rojo, Azul]
        System.out.println();

        // 4. intersection - Encuentra la intersección de dos colecciones
        Collection<String> collection7 = Arrays.asList("Manzana", "Banana", "Cereza");
        Collection<String> collection8 = Arrays.asList("Banana", "Cereza", "Durazno");

        System.out.println("intersection:");
        Collection<String> intersection = CollectionUtils.intersection(collection7, collection8);
        System.out.println(intersection); // [Banana, Cereza]
        System.out.println();

        // 5. union - Une dos colecciones, eliminando duplicados
        Collection<String> collection9 = Arrays.asList("Rojo", "Verde");
        Collection<String> collection10 = Arrays.asList("Verde", "Azul");

        System.out.println("union:");
        Collection<String> union = CollectionUtils.union(collection9, collection10);
        System.out.println(union); // [Rojo, Verde, Azul]
        System.out.println();

        // Ejemplos adicionales de operaciones entre conjuntos

        // 6. subtract - Encuentra la diferencia entre dos colecciones
        Collection<String> collection11 = Arrays.asList("A", "B", "C");
        Collection<String> collection12 = Arrays.asList("B", "C", "D");

        System.out.println("subtract:");
        Collection<String> difference = CollectionUtils.subtract(collection11, collection12);
        System.out.println(difference); // [A]

        // 7. disjunction - Encuentra los elementos que están en una colección o en otra, pero no en ambas
        System.out.println("disjunction:");
        Collection<String> disjunction = CollectionUtils.disjunction(collection11, collection12);
        System.out.println(disjunction); // [A, D]

        // 8. select - Selecciona elementos de una colección que cumplen una condición
        Collection<String> collection13 = Arrays.asList("Apple", "Banana", "Cherry", "Avocado");
        System.out.println("select:");

        // La siguiente línea es análoga a escribir un filtro con streams:
        // collection13.stream().filter(x -> x.startsWith("A")).toList();
        Collection<String> selected = CollectionUtils.select(collection13, s -> s.startsWith("A"));
        System.out.println(selected); // [Apple, Avocado]

        // 9. transform - Transforma los elementos de una colección usando una función
        System.out.println("transform:");
        // La siguiente línea es análoga a escribir un filtro con streams:
        // collection13.stream().map(x -> x.toUpperCase()).toList();
        Collection<String> transformed = CollectionUtils.collect(collection13, String::toUpperCase);
        System.out.println(transformed); // [APPLE, BANANA, CHERRY, AVOCADO]

        // 10. predicate - Selecciona elementos de una colección que cumplen una condición usando Predicate
        System.out.println("predicate:");
        Collection<String> predicateResult = CollectionUtils.select(collection13, s -> s.length() > 5);
        System.out.println(predicateResult); // [Banana, Cherry, Avocado]
    }
}
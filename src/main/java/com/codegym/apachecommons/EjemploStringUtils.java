package com.codegym.apachecommons;

import org.apache.commons.lang3.StringUtils;


public class EjemploStringUtils {
    public static void main(String[] args) {
        String str1 = "Hola, Apache Commons!";
        String str2 = "HOLA, APACHE COMMONS!";
        String str3 = new String("Hola");
        String str4 = "";
        String str5 = " ";
        String str6 = "Hola";
        String str8 = "Hola";
        String str9 = null;

        System.out.println("Repaso string pool y referencias");
        System.out.println(str6 == str3);
        System.out.println(str6 == str8);
        System.out.println(str6.equals(str3));
        System.out.println();

        // 1. isEmpty - Verifica si la cadena es vacía o null
        System.out.println("isEmpty:");
        System.out.println(StringUtils.isEmpty(str4)); // true
        System.out.println(StringUtils.isEmpty(str1)); // false
        System.out.println(StringUtils.isEmpty(str5)); // false
        System.out.println(StringUtils.isEmpty(str9)); // true
        System.out.println();

        // 2. equals - Compara dos cadenas de manera segura (maneja nulls)
        System.out.println("equals:");
        System.out.println(StringUtils.equals(str1, str2)); // false
        System.out.println(StringUtils.equals(str3, "Hola")); // true
        System.out.println(StringUtils.equals(str6, str9));
        System.out.println();

        // 3. compare - Compara dos cadenas, devolviendo un int
        System.out.println("compare:");
        System.out.println(StringUtils.compare(str1, str2)); // > 0 porque str1 es mayor (por comparación lexicográfica)
        System.out.println(StringUtils.compare(str3, "Hola")); // 0 porque son iguales
        System.out.println(StringUtils.compare(str3, "Jola")); // < 0 porque "Hola" es mayor que "Jola"
        System.out.println();

        // 4. indexOf - Encuentra la posición de un carácter o subcadena en una cadena
        System.out.println("indexOf:");
        System.out.println(StringUtils.indexOf(str1, 'A')); // 6
        System.out.println(StringUtils.indexOf(str1, "Apache")); // 6
        System.out.println(StringUtils.indexOf(str1, 'B')); // -1 porque no está presente
        System.out.println();

        // 5. lastIndexOf - Encuentra la última posición de un carácter o subcadena en una cadena
        System.out.println("lastIndexOf:");
        System.out.println(StringUtils.lastIndexOf(str1, 'o')); // 17
        System.out.println(StringUtils.lastIndexOf(str1, "Commons")); // 13
        System.out.println();

        // 6. contains - Verifica si una subcadena está presente en la cadena
        System.out.println("contains:");
        System.out.println(StringUtils.contains(str1, "Apache")); // true
        System.out.println(StringUtils.contains(str1, "Java")); // false
        System.out.println();

        // 7. containsIgnoreCase - Verifica si una subcadena está presente, ignorando mayúsculas y minúsculas
        System.out.println("containsIgnoreCase:");
        System.out.println(StringUtils.containsIgnoreCase(str1, "apache")); // true
        System.out.println(StringUtils.containsIgnoreCase(str1, "JAVA")); // false
        System.out.println();

        // 8. containsAny - Verifica si la cadena contiene alguno de los caracteres proporcionados
        System.out.println("containsAny:");
        System.out.println(StringUtils.containsAny(str1, 'A', 'Z')); // true ('A' está presente)
        System.out.println(StringUtils.containsAny(str1, 'x', 'y', 'z')); // false (ninguno de esos caracteres está presente)
        System.out.println();

        // 9. containsNone - Verifica que la cadena no contenga ninguno de los caracteres proporcionados
        System.out.println("containsNone:");
        System.out.println(StringUtils.containsNone(str1, 'x', 'y', 'z')); // true (ninguno de esos caracteres está presente)
        System.out.println(StringUtils.containsNone(str1, 'A', 'B')); // false ('A' está presente)
        System.out.println();

        // 10. containsOnly - Verifica si la cadena solo contiene los caracteres proporcionados
        System.out.println("containsOnly:");
        System.out.println(StringUtils.containsOnly(str3, "Hol")); // false (contiene 'a', que no está en "Hol")
        System.out.println(StringUtils.containsOnly("AAA", 'A')); // true (solo contiene 'A')
        System.out.println();

        // 11. isBlank - Verifica si una cadena de caracteres contiene solo espacios
        System.out.println("isBlank:");
        System.out.println(StringUtils.isBlank(str4)); // true
        System.out.println(StringUtils.isBlank(str1)); // false
        System.out.println(StringUtils.isBlank(str5)); // true

    }
}
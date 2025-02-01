package com.codegym.apachecommons;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;

public class Persona implements Cloneable {
    private String nombre;
    private int edad;
    private String direccion;
    private boolean casado;

    public Persona(String nombre, int edad, String direccion, boolean casado) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.casado = casado;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        Persona persona = (Persona) object;

        return new EqualsBuilder()
            .append(edad, persona.edad)
            .append(casado, persona.casado)
            .append(nombre, persona.nombre)
            .append(direccion, persona.direccion)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(nombre)
            .append(edad)
            .append(direccion)
            .append(casado)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("nombre", nombre)
            .append("edad", edad)
            .append("direccion", direccion)
            .append("casado", casado)
            .toString();
    }

    @Override
    public Persona clone() {
        return new Persona(this.nombre, this.edad, this.direccion, this.casado);
    }

    public static void main(String[] args) {
        Persona p1 = new Persona("Alejandro", 39, "123 Fake Street", true);
        Persona p2 = new Persona("Karen", 31, "456 Washington Avenue", false);
        Persona p3 = new Persona("Alejandro", 39, "123 Fake Street", true);

        System.out.println("USANDO EQUALS COMPLEJO");
        System.out.println("P1 y P2 son iguales?: " + p1.equals(p2)); // p2.equals(p1)
        System.out.println("P1 y P3 son iguales?: " + p3.equals(p1)); // p1.equals(p3)
        System.out.println();

        System.out.println("USANDO HASHCODE COMPLEJO");
        System.out.println("Hashcode de P1: " + p1.hashCode());
        System.out.println("Hashcode de P2: " + p2.hashCode());
        System.out.println("Hashcode de P3: " + p3.hashCode());
        System.out.println();

        System.out.println("USANDO TOSTRING COMPLEJO");
        System.out.println(p2);
        System.out.println();
    }

}

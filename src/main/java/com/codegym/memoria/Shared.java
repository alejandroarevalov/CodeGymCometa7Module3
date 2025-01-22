package com.codegym.memoria;

public class Shared {

    // store an instance of our object in a variable

    public static final Shared instance = new Shared();

    // member variables pointing to two objects on the heap

    public String object2 = "Hola";
    public String object4 = "Mundo";
}
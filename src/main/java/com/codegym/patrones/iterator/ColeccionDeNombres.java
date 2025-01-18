package com.codegym.patrones.iterator;

import java.util.ArrayList;
import java.util.List;

public class ColeccionDeNombres implements Coleccion<String> {
    private List<String> nombres = new ArrayList<>();

    public void agregarNombre(String nombre) {
        nombres.add(nombre);
    }

    @Override
    public Iterador<String> obtenerIterador() {
        return new IteradorLista<>(nombres);
    }
}

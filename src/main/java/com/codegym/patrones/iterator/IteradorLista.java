package com.codegym.patrones.iterator;

import java.util.List;

// Iterador concreto
public class IteradorLista<T> implements Iterador {
    private List<T> elementos;
    private int posicion = 0;

    public IteradorLista(List<T> elementos) {
        this.elementos = elementos;
    }

    @Override
    public boolean tieneSiguiente() {
        return posicion < elementos.size();
    }

    @Override
    public T siguiente() {
        if (!tieneSiguiente()) {
            throw new IllegalStateException("No hay más elementos.");
        }
        return elementos.get(posicion++);
    }
}

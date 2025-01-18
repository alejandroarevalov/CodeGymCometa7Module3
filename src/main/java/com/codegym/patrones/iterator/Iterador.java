package com.codegym.patrones.iterator;

interface Iterador<T> {
    boolean tieneSiguiente();
    T siguiente();
}

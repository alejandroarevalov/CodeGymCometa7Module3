package com.codegym.patrones.iterator;

interface Coleccion<T> {
    Iterador<T> obtenerIterador();
}
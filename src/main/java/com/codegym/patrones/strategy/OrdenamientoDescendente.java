package com.codegym.patrones.strategy;

import java.util.Collections;
import java.util.List;

public class OrdenamientoDescendente implements EstrategiaOrdenamiento {
    @Override
    public void ordenar(List<String> lista) {
        Collections.sort(lista, Collections.reverseOrder());
        System.out.println("Lista ordenada de manera descendente: " + lista);
    }
}

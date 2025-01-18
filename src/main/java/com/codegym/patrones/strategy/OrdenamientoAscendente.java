package com.codegym.patrones.strategy;

import java.util.Collections;
import java.util.List;

public class OrdenamientoAscendente implements EstrategiaOrdenamiento {
    @Override
    public void ordenar(List<String> lista) {
        Collections.sort(lista);
        System.out.println("Lista ordenada de manera ascendente: " + lista);
    }
}

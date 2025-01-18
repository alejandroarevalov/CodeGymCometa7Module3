package com.codegym.patrones.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>(
            Arrays.asList("Manzana", "Naranja", "Plátano", "Cereza", "Uva")
        );

        // Usamos la estrategia de ordenamiento ascendente
        Ordenador ordenador = new Ordenador(new OrdenamientoAscendente());
        ordenador.ordenarLista(lista);

        // Cambiamos la estrategia a ordenamiento descendente
        ordenador.setEstrategia(new OrdenamientoDescendente());
        ordenador.ordenarLista(lista);
    }
}

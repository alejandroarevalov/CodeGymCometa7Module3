package com.codegym.patrones.strategy;

import java.util.List;

public class Ordenador {
    private EstrategiaOrdenamiento estrategia;

    public Ordenador(EstrategiaOrdenamiento estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaOrdenamiento estrategia) {
        this.estrategia = estrategia;
    }

    public void ordenarLista(List<String> lista) {
        estrategia.ordenar(lista);
    }
}

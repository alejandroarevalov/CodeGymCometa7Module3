package com.codegym.patrones.memento;

import java.util.LinkedList;
import java.util.Queue;

// Cuidador (CareTaker)
public class Cuidador {

    private Queue<Memento> listaMementos;

    public Cuidador() {
        listaMementos = new LinkedList<>();
    }

    public void guardarMemento(Memento memento) {
        listaMementos.add(memento);
    }

    public Memento obtenerMemento() {
        return listaMementos.poll();
    }
}

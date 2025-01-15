package com.codegym.patrones.objectpool;

import java.util.LinkedList;
import java.util.Queue;

public class FormularioPool {
    private final Queue<Formulario> pool;

    public FormularioPool(int tamañoMaximo) {
        pool = new LinkedList<>();
        for (int i = 1; i <= tamañoMaximo; i++) {
            pool.offer(new Formulario(i)); // Crear formularios y agregarlos al pool
        }
    }

    // Obtener un formulario del pool
    public Formulario obtenerFormulario() {
        if (pool.isEmpty()) {
            throw new RuntimeException("No hay formularios disponibles.");
        }
        return pool.poll();
    }

    // Devolver un formulario al pool
    public void devolverFormulario(Formulario formulario) {
        formulario.reset(); // Reiniciar el formulario antes de devolverlo
        pool.offer(formulario);
    }
}

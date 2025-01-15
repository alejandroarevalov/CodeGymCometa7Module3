package com.codegym.patrones.facade;

public class SistemaDeAudio {
    public void encender() {
        System.out.println("Sistema de audio encendido.");
    }

    public void apagar() {
        System.out.println("Sistema de audio apagado.");
    }

    public void subirVolumen() {
        System.out.println("Subiendo volumen.");
    }

    public void bajarVolumen() {
        System.out.println("Bajando volumen.");
    }
}
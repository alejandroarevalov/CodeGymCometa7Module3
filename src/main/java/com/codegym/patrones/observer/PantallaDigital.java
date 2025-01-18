package com.codegym.patrones.observer;

public class PantallaDigital implements Observador {
    @Override
    public void actualizar(float temperatura) {
        System.out.println("📟 La Pantalla Digital muestra la temperatura: " + temperatura + "°C");
    }
}

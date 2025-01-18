package com.codegym.patrones.observer;

public class SistemaDeAlertas implements Observador {
    @Override
    public void actualizar(float temperatura) {
        if (temperatura > 30) {
            System.out.println("🚨 ALERTA: La temperatura ha superado los 30°C!");
        }
    }
}

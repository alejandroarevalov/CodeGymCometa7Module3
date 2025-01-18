package com.codegym.patrones.observer;

public class Cliente {
    public static void main(String[] args) {
        // Crear el observable (Sensor de temperatura)
        SensorTemperatura sensor = new SensorTemperatura();

        // Crear los observadores
        PantallaDigital pantalla = new PantallaDigital();
        SistemaDeAlertas alertas = new SistemaDeAlertas();

        // Suscribir los observadores al sensor
        sensor.agregarObservador(pantalla);
        sensor.agregarObservador(alertas);

        // Cambiar la temperatura y notificar a los observadores
        sensor.setTemperatura(25);
        System.out.println("-----------------------------");
        sensor.setTemperatura(32);
    }
}

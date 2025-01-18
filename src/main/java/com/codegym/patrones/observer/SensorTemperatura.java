package com.codegym.patrones.observer;

public class SensorTemperatura extends Observable {
    private float temperatura;

    public void setTemperatura(float nuevaTemperatura) {
        this.temperatura = nuevaTemperatura;
        System.out.println("🌡️ Nueva temperatura registrada: " + temperatura + "°C");
        this.notificarObservadores(temperatura);
    }
}

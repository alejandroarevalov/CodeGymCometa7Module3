package com.codegym.patrones.factorymethod;

public class Motocicleta implements Vehiculo {
    @Override
    public String encenderMotor() {
        return "El motor de la moto arranca: Brum Brum!";
    }
}

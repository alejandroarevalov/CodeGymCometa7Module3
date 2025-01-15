package com.codegym.patrones.factorymethod;

public class Automovil implements Vehiculo {
    @Override
    public String encenderMotor() {
        return "El motor del coche arranca: Vruum Vruum!";
    }
}
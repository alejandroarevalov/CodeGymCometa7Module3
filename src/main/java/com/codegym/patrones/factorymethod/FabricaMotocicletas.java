package com.codegym.patrones.factorymethod;

public class FabricaMotocicletas extends FabricaVehiculos {
    @Override
    public Vehiculo crearVehiculo() {
        return new Motocicleta();
    }
}
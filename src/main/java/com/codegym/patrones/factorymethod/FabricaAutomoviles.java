package com.codegym.patrones.factorymethod;

public class FabricaAutomoviles extends FabricaVehiculos {
    @Override
    public Vehiculo crearVehiculo() {
        return new Automovil();
    }
}

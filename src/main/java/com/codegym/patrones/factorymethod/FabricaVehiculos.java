package com.codegym.patrones.factorymethod;

public abstract class FabricaVehiculos {
    // Método Fábrica
    public abstract Vehiculo crearVehiculo();

    // Método que usa el Método Fábrica
    public String encenderMotorVehiculo() {
        // Llamamos al Método Fábrica para crear el Vehículo
        Vehiculo vehiculo = crearVehiculo();
        return vehiculo.encenderMotor();
    }
}

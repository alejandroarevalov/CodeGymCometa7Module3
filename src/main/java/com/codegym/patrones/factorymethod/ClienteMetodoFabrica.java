package com.codegym.patrones.factorymethod;

public class ClienteMetodoFabrica {
    public static void main(String[] args) {
        FabricaVehiculos fabricaAutomoviles = new FabricaAutomoviles();
        FabricaVehiculos fabricaMotocicletas = new FabricaMotocicletas();

        System.out.println(fabricaAutomoviles.encenderMotorVehiculo());
        System.out.println(fabricaMotocicletas.encenderMotorVehiculo());
    }
}

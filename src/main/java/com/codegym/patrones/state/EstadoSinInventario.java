package com.codegym.patrones.state;

public class EstadoSinInventario implements Estado {
    private MaquinaExpendedora maquina;

    public EstadoSinInventario(MaquinaExpendedora maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarMoneda() {
        System.out.println("No hay productos disponibles.");
    }

    @Override
    public void expulsarMoneda() {
        System.out.println("No hay moneda que expulsar.");
    }

    @Override
    public void presionarBoton() {
        System.out.println("No hay productos para dispensar.");
    }

    @Override
    public void dispensar() {
        System.out.println("No se puede dispensar.");
    }
}

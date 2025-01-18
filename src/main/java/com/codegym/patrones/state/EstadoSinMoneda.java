package com.codegym.patrones.state;

public class EstadoSinMoneda implements Estado {
    private MaquinaExpendedora maquina;

    public EstadoSinMoneda(MaquinaExpendedora maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarMoneda() {
        System.out.println("Moneda insertada. Puedes seleccionar un producto.");
        maquina.setEstado(maquina.getEstadoConMoneda());
    }

    @Override
    public void expulsarMoneda() {
        System.out.println("No hay moneda que expulsar.");
    }

    @Override
    public void presionarBoton() {
        System.out.println("Primero debes insertar una moneda.");
    }

    @Override
    public void dispensar() {
        System.out.println("Debes pagar antes de recibir un producto.");
    }
}

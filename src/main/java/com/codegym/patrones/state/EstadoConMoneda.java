package com.codegym.patrones.state;

public class EstadoConMoneda implements Estado {
    private MaquinaExpendedora maquina;

    public EstadoConMoneda(MaquinaExpendedora maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarMoneda() {
        System.out.println("Ya has insertado una moneda.");
    }

    @Override
    public void expulsarMoneda() {
        System.out.println("Moneda expulsada.");
        maquina.setEstado(maquina.getEstadoSinMoneda());
    }

    @Override
    public void presionarBoton() {
        System.out.println("Producto dispensado.");
        maquina.liberarProducto();
    }

    @Override
    public void dispensar() {
        System.out.println("Presiona el botón para recibir tu producto.");
    }
}

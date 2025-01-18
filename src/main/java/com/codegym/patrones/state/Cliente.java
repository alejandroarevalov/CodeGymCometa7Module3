package com.codegym.patrones.state;

public class Cliente {
    public static void main(String[] args) {
        MaquinaExpendedora maquina = new MaquinaExpendedora(2);

        maquina.insertarMoneda();
        maquina.presionarBoton();

        maquina.insertarMoneda();
        maquina.expulsarMoneda();

        maquina.insertarMoneda();
        maquina.presionarBoton();

        maquina.insertarMoneda();
    }
}

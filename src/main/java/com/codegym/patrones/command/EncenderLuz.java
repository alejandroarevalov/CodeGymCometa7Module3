package com.codegym.patrones.command;

public class EncenderLuz implements Comando {
    private Luz luz;

    public EncenderLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void ejecutarAccion() {
        luz.encender();
    }
}

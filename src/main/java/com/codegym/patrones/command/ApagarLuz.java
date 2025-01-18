package com.codegym.patrones.command;

public class ApagarLuz implements Comando {
    private Luz luz;

    public ApagarLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void ejecutarAccion() {
        luz.apagar();
    }
}

package com.codegym.patrones.command;

public class Cliente {
    public static void main(String[] args) {
        Luz luz = new Luz();
        Comando encender = new EncenderLuz(luz);
        Comando apagar = new ApagarLuz(luz);

        ControlRemoto control = new ControlRemoto();

        System.out.println("Presionando botón para ENCENDER:");
        control.setComando(encender);
        control.presionarBoton();

        System.out.println("\nPresionando botón para APAGAR:");
        control.setComando(apagar);
        control.presionarBoton();
    }
}

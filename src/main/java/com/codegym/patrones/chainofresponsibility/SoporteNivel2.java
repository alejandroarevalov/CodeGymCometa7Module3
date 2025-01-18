package com.codegym.patrones.chainofresponsibility;

public class SoporteNivel2 extends Soporte {

    @Override
    public void manejarSolicitud(String tipoDeProblema) {
        if (tipoDeProblema.equals("Problema de hardware")) {
            System.out.println("Soporte Nivel 2: Resolviendo el problema de hardware.");
        } else if (siguienteSoporte != null) {
            siguienteSoporte.manejarSolicitud(tipoDeProblema);
        }
    }
}

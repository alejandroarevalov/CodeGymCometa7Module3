package com.codegym.patrones.chainofresponsibility;

public class SoporteNivel3 extends Soporte {

    @Override
    public void manejarSolicitud(String tipoDeProblema) {
        if (tipoDeProblema.equals("Problema de red o software")) {
            System.out.println("Soporte Nivel 3: Resolviendo el problema de red o software.");
        } else {
            System.out.println("Problema no soportado.");
        }
    }
}
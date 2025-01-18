package com.codegym.patrones.chainofresponsibility;

public class SoporteNivel1 extends Soporte {
    @Override
    public void manejarSolicitud(String tipoDeProblema) {
        if (tipoDeProblema.equals("Contraseña olvidada")) {
            System.out.println("Soporte Nivel 1: Resolviendo el problema de contraseña olvidada.");
        } else if (siguienteSoporte != null) {
            siguienteSoporte.manejarSolicitud(tipoDeProblema);
        }
    }
}

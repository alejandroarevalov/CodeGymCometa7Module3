package com.codegym.patrones.chainofresponsibility;

public class Cliente {
    public static void main(String[] args) {
        // Crear los objetos de soporte
        Soporte soporte1 = new SoporteNivel1();
        Soporte soporte2 = new SoporteNivel2();
        Soporte soporte3 = new SoporteNivel3();

        // Establecer la cadena de responsabilidad
        soporte1.setSiguienteSoporte(soporte2);
        soporte2.setSiguienteSoporte(soporte3);

        // Hacer solicitudes
        System.out.println("Solicitud: 'Contraseña olvidada'");
        soporte1.manejarSolicitud("Contraseña olvidada");

        System.out.println("\nSolicitud: 'Problema de hardware'");
        soporte1.manejarSolicitud("Problema de hardware");

        System.out.println("\nSolicitud: 'Problema de red o software'");
        soporte1.manejarSolicitud("Problema de red o software");

        System.out.println("\nSolicitud: 'Problema desconocido'");
        soporte1.manejarSolicitud("Problema desconocido");
    }
}

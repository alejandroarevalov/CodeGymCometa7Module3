package com.codegym.patrones.chainofresponsibility;

public abstract class Soporte {
    // Referencia al siguiente nivel de soporte
    protected Soporte siguienteSoporte;

    // Se establece el siguiente soporte en la cadena
    public void setSiguienteSoporte(Soporte siguienteSoporte) {
        this.siguienteSoporte = siguienteSoporte;
    }

    // Método abstracto para manejar la solicitud
    public abstract void manejarSolicitud(String tipoDeProblema);
}

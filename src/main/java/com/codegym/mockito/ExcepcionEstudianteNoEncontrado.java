package com.codegym.mockito;

public class ExcepcionEstudianteNoEncontrado extends RuntimeException {

    private static final String MENSAJE = "Estudiante no encontrado";
    public ExcepcionEstudianteNoEncontrado() {
        super(MENSAJE);
    }
}

package com.codegym.mockito;

public class ExcepcionContrasenaBaseDeDatos extends RuntimeException {

    public ExcepcionContrasenaBaseDeDatos() {
        super("Nombre de usuario y/o contrasena invalida");
    }
}

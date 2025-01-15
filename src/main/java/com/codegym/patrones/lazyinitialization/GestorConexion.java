package com.codegym.patrones.lazyinitialization;

public class GestorConexion {
    private ConexionBaseDeDatos conexion; // No se inicializa al principio.

    public ConexionBaseDeDatos getConexion() {
        if (conexion == null) {
            // La conexión solo se crea cuando se necesita.
            conexion = new ConexionBaseDeDatos();
        }
        return conexion;
    }
}

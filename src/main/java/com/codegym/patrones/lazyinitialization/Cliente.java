package com.codegym.patrones.lazyinitialization;

public class Cliente {
    public static void main(String[] args) {
        GestorConexion gestor = new GestorConexion();

        System.out.println("Aplicación iniciada, pero la conexión no se ha establecido aún.");

        // La conexión se inicializa aquí, solo cuando se necesita.
        ConexionBaseDeDatos conexion = gestor.getConexion();
        System.out.println("Estado de la conexión: " + conexion.getConexionInfo());

        // La conexión ya está creada, no se vuelve a inicializar.
        ConexionBaseDeDatos otraConexion = gestor.getConexion();
        System.out.println("Estado de la conexión reutilizada: " + otraConexion.getConexionInfo());
    }
}

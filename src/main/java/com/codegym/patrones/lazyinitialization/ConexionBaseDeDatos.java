package com.codegym.patrones.lazyinitialization;

public class ConexionBaseDeDatos {
    private String conexionInfo;

    public ConexionBaseDeDatos() {
        // Simulación de un proceso costoso, como establecer una conexión real.
        System.out.println("Estableciendo conexión a la base de datos...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.conexionInfo = "Conexión establecida";
    }

    public String getConexionInfo() {
        return conexionInfo;
    }
}


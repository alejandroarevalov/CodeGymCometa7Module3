package com.codegym.patrones.objectpool;

public class Cliente {
    public static void main(String[] args) {
        // Crear un pool con 3 formularios disponibles
        FormularioPool pool = new FormularioPool(3);

        // Cliente 1 obtiene un formulario
        Formulario formulario1 = pool.obtenerFormulario();
        formulario1.llenar("Cliente 1");

        // Cliente 2 obtiene un formulario
        Formulario formulario2 = pool.obtenerFormulario();
        formulario2.llenar("Cliente 2");

        // Cliente 3 obtiene un formulario (reutiliza el formulario 1)
        Formulario formulario3 = pool.obtenerFormulario();
        formulario3.llenar("Cliente 3");

        // Cliente 4 intenta obtener un formulario (pero no hay más disponibles)
        try {
            Formulario formulario4 = pool.obtenerFormulario();
            formulario4.llenar("Cliente 4");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            pool.devolverFormulario(formulario1);
        }

        Formulario formulario4 = pool.obtenerFormulario();
        formulario4.llenar("Cliente 4");
    }
}
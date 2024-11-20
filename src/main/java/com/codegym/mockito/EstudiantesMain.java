package com.codegym.mockito;

public class EstudiantesMain {

    public static void main(String[] args) {

        BaseDeDatosEstudiantes baseDeDatosEstudiantes = new BaseDeDatosEstudiantes("abc", "123");
        ServicioAtencionEstudiantes servicioAtencionEstudiantes = new ServicioAtencionEstudiantes(baseDeDatosEstudiantes);

        System.out.println(servicioAtencionEstudiantes.obtenerTodosLosEstudiantesParaImprimir());
        System.out.println("--".repeat(40));
        System.out.println(servicioAtencionEstudiantes.obtenerEstudiantesDestacadosParaImprimir(4.0f));
        System.out.println("--".repeat(40));
        System.out.println(servicioAtencionEstudiantes.obtenerEstudiantePorNombreParaImprimir("Alejandro Arevalo"));
        System.out.println("--".repeat(40));
        System.out.println(servicioAtencionEstudiantes.obtenerEstudiantesOrdenadosPorNombreParaImprimir());
        System.out.println("--".repeat(40));
        servicioAtencionEstudiantes.agregarEstudiantes(4);
    }
}

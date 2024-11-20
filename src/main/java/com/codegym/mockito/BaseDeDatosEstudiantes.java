package com.codegym.mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class BaseDeDatosEstudiantes {

    private List<Estudiante> estudiantes;
    private static final Estudiante estudianteVacio = new Estudiante();

    public BaseDeDatosEstudiantes(String usuario, String contrasena) {
        if (usuario == "abc" && contrasena == "123") {
            estudiantes = new ArrayList<>();
            estudiantes.add(new Estudiante("Pepe Moreno", 3.5F));
            estudiantes.add(new Estudiante("Jahir Benitez", 2.5F));
            estudiantes.add(new Estudiante("Alejandro Arevalo", 5.0F));
            estudiantes.add(new Estudiante("Claudia Palacios", 4.8F));
            estudiantes.add(new Estudiante("Anselmo Vega", 4.0F));
            estudiantes.add(new Estudiante("Hansel Camacho", 1.7F));
        } else {
            throw new ExcepcionContrasenaBaseDeDatos();
        }
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudiantes;
    }

    public List<Estudiante> obtenerEstudiantesConCalificacionSuperiorA(float umbral) {
        return estudiantes.stream().filter(e -> e.getCalificacion() > umbral).toList();
    }

    public Estudiante obtenerEstudiantePorNombre(String nombreCompleto) {
        return estudiantes.stream().filter(e -> e.getNombre().equals(nombreCompleto))
            .findFirst()
            .orElseThrow(() -> new ExcepcionEstudianteNoEncontrado());
    }

    public List<Estudiante> obtenerEstudiantesOrdenadosPorNombre() {
        return estudiantes.stream().sorted(Comparator.comparing(Estudiante::getNombre)).toList();
    }

    public void agregarEstudiante(String nombre, Float calificacion) {
        Estudiante nuevoEstudiante = new Estudiante(nombre, calificacion);
        estudiantes.add(nuevoEstudiante);
        System.out.println("Estudiante agregado:\n" + nuevoEstudiante);
    }

    public static Estudiante obtenerEstudianteSinInformacion() {
        return estudianteVacio;
    }
}

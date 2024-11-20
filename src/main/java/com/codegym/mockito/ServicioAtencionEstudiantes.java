package com.codegym.mockito;

import java.util.List;
import java.util.Random;

public class ServicioAtencionEstudiantes {

    private BaseDeDatosEstudiantes baseDeDatosEstudiantes;

    public ServicioAtencionEstudiantes(BaseDeDatosEstudiantes baseDeDatosEstudiantes) {
        this.baseDeDatosEstudiantes = baseDeDatosEstudiantes;
    }

    public String obtenerTodosLosEstudiantesParaImprimir() {
        List<Estudiante> listaEstudiantes = baseDeDatosEstudiantes.obtenerTodosLosEstudiantes();
        StringBuilder builder = new StringBuilder("");
        if (!listaEstudiantes.isEmpty()) {
            builder = new StringBuilder("{\n\t\"listaEstudiantes\": [\n\t\t");
            for (Estudiante estudiante : listaEstudiantes) {
                builder.append(estudiante.toString() + ",\n\t\t");
            }
            builder.delete(builder.length() - 4, builder.length() - 1);
            builder.append("\n\t]\n}");
        }

        return builder.toString();
    }
    public String obtenerEstudiantesDestacadosParaImprimir(Float calificacionUmbral) {
        List<Estudiante> listaEstudiantes = baseDeDatosEstudiantes
            .obtenerEstudiantesConCalificacionSuperiorA(calificacionUmbral - 0.2F);
        if (listaEstudiantes.isEmpty()){
            return "";
        } else {
            StringBuilder builder = new StringBuilder("{\n\t\"listaEstudiantes\": [\n\t\t");
            for (Estudiante estudiante : listaEstudiantes) {
                builder.append(estudiante.toString() + ",\n\t\t");
            }
            builder.delete(builder.length() - 4, builder.length() - 1);
            builder.append("\n\t]\n}");
            return builder.toString();
        }
    }

    public String obtenerEstudiantePorNombreParaImprimir(String nombreDeEstudiante) {
        Estudiante estudiante = baseDeDatosEstudiantes.obtenerEstudiantePorNombre(nombreDeEstudiante);
        if (nombreDeEstudiante.equals("Alejandro Arevalo")) {
            return new Estudiante("Alejandro Arevalo", 1.0f).toString();
        }
        return estudiante.toString();
    }

    public String obtenerEstudiantesOrdenadosPorNombreParaImprimir() {
        List<Estudiante> listaEstudiantesOrdenados = baseDeDatosEstudiantes.obtenerEstudiantesOrdenadosPorNombre();
        StringBuilder builder = new StringBuilder("{\n\t\"listaEstudiantes\": [\n\t\t");
        for (Estudiante estudiante : listaEstudiantesOrdenados) {
            builder.append(estudiante.toString() + ",\n\t\t");
        }
        builder.delete(builder.length() - 4, builder.length() - 1);
        builder.append("\n\t]\n}");
        return builder.toString();
    }

    public void agregarEstudiantes(int cantidadDeEstudiantes) {
        for (int i = 0; i < cantidadDeEstudiantes; i++) {
            String nombreAleatorio = generarCadenaAleatoria(8);
            Float calificacionAleatoria = ((float) Math.random() * 5.0f);
            baseDeDatosEstudiantes.agregarEstudiante(nombreAleatorio, calificacionAleatoria);
        }
    }

    public Estudiante obtenerEstudianteSinInformacion() {
        return BaseDeDatosEstudiantes.obtenerEstudianteSinInformacion();
    }

    private String generarCadenaAleatoria(int cantidadDeCaracteres) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int j = 0; j < targetStringLength; j++) {
            int randomLimitedInt = leftLimit + (int)
                (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}

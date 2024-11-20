package com.codegym.mockito;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {
    private String nombre;
    private Float calificacion;

    @Override
    public String toString() {
        return String.format(Locale.getDefault(),"{ \"nombre\": \"%s\", \"calificacion\": %.1f }", nombre, calificacion);
    }
}

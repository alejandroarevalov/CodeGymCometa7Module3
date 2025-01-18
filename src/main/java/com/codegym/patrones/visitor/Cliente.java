package com.codegym.patrones.visitor;

import java.util.Arrays;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        // Crear una lista de figuras geométricas
        List<Figura> figuras = Arrays.asList(
            new Circulo(5),
            new Cuadrado(4),
            new Rectangulo(3, 6)
        );

        // Crear los visitantes
        Visitante calculadorArea = new CalculadorDeArea();
        Visitante calculadorPerimetro = new CalculadorDePerimetro();

        // Aplicar visitantes a todas las figuras
        System.out.println("=== Cálculo de Áreas ===");
        for (Figura figura : figuras) {
            figura.aceptar(calculadorArea);
        }

        System.out.println("\n=== Cálculo de Perímetros ===");
        for (Figura figura : figuras) {
            figura.aceptar(calculadorPerimetro);
        }
    }
}

package com.codegym.patrones.bridge;
public class ClienteBridgeFigurasColores {
    public static void main(String[] args) {
        // Crear colores
        Color rojo = new Rojo();
        Color azul = new Azul();

        // Crear figuras con diferentes colores
        Figura circuloRojo = new Circulo(rojo);
        Figura rectanguloRojo = new Rectangulo(rojo);
        Figura rectanguloAzul = new Rectangulo(azul);

        // Dibujar las figuras
        circuloRojo.dibujar();
        rectanguloAzul.dibujar();
        rectanguloRojo.dibujar();
    }
}

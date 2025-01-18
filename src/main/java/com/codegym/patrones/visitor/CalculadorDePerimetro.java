package com.codegym.patrones.visitor;

public class CalculadorDePerimetro implements Visitante {
    @Override
    public void visitarCirculo(Circulo circulo) {
        double perimetro = 2 * Math.PI * circulo.getRadio();
        System.out.println("🟢 Perímetro del Círculo: " + perimetro);
    }

    @Override
    public void visitarCuadrado(Cuadrado cuadrado) {
        double perimetro = 4 * cuadrado.getLado();
        System.out.println("🔲 Perímetro del Cuadrado: " + perimetro);
    }

    @Override
    public void visitarRectangulo(Rectangulo rectangulo) {
        double perimetro = 2 * (rectangulo.getAncho() + rectangulo.getAlto());
        System.out.println("⬛ Perímetro del Rectángulo: " + perimetro);
    }
}

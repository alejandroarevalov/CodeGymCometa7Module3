package com.codegym.patrones.visitor;

public class CalculadorDeArea implements Visitante {
    @Override
    public void visitarCirculo(Circulo circulo) {
        double area = Math.PI * Math.pow(circulo.getRadio(), 2);
        System.out.println("🟢 Área del Círculo: " + area);
    }

    @Override
    public void visitarCuadrado(Cuadrado cuadrado) {
        double area = Math.pow(cuadrado.getLado(), 2);
        System.out.println("🔲 Área del Cuadrado: " + area);
    }

    @Override
    public void visitarRectangulo(Rectangulo rectangulo) {
        double area = rectangulo.getAncho() * rectangulo.getAlto();
        System.out.println("⬛ Área del Rectángulo: " + area);
    }
}

package com.codegym.patrones.visitor;

public interface Visitante {
    void visitarCirculo(Circulo circulo);
    void visitarCuadrado(Cuadrado cuadrado);
    void visitarRectangulo(Rectangulo rectangulo);
}

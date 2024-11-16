package com.codegym.calculadora;

public class Calculadora {

    public int sumar(int x, int y) {
        return x + y;
    }

    public int restar(int x, int y) {
        return x - y;
    }

    public int multiplicar(int x, int y) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return x * y;
    }

}

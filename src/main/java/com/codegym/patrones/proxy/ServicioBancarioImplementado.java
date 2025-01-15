package com.codegym.patrones.proxy;

public class ServicioBancarioImplementado implements ServicioBancario {
    @Override
    public void realizarTransaccion(String tipo, double monto) {
        System.out.println("Transacción realizada: " + tipo + " por $" + monto);
    }
}

package com.codegym.patrones.proxy;

public class Cliente {
    public static void main(String[] args) {
        ServicioBancario servicio = new ProxyServicioBancario(new ServicioBancarioImplementado());

        // Usuario autorizado para depósito
        servicio.realizarTransaccion("deposito", 1000);

        // Usuario no autorizado para retiro
        servicio.realizarTransaccion("retiro", 500);
    }
}

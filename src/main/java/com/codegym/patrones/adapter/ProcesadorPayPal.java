package com.codegym.patrones.adapter;

// Clase adaptada
public class ProcesadorPayPal {

    public void recibirPago(double cantidad) {
        System.out.println("Pago de " + cantidad + " procesado por PayPal.");
    }
}

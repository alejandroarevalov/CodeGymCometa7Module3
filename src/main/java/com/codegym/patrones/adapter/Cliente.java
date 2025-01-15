package com.codegym.patrones.adapter;

public class Cliente {

    public static void main(String[] args) {
        ProcesadorPagos adaptadorPayPal = new AdaptadorPayPal(new ProcesadorPayPal());
        adaptadorPayPal.procesarPago(300);

        ProcesadorPagos adaptadorStripe = new AdaptadorStripe(new ProcesadorStripe());
        adaptadorStripe.procesarPago(1000);
    }
}

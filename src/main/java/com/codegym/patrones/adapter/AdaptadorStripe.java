package com.codegym.patrones.adapter;

public class AdaptadorStripe implements ProcesadorPagos {

    private ProcesadorStripe procesadorStripe;

    public AdaptadorStripe(ProcesadorStripe procesadorStripe) {
        this.procesadorStripe = procesadorStripe;
    }
    @Override
    public void procesarPago(double monto) {
        procesadorStripe.realizarPago(monto);
    }
}

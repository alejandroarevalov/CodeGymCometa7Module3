package com.codegym.patrones.adapter;

public class AdaptadorPayPal implements ProcesadorPagos {

    private ProcesadorPayPal procesadorPayPal;

    public AdaptadorPayPal(ProcesadorPayPal procesadorPayPal) {
        this.procesadorPayPal = procesadorPayPal;
    }

    @Override
    public void procesarPago(double monto) {
        procesadorPayPal.recibirPago(monto);
    }
}

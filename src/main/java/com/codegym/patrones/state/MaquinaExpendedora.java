package com.codegym.patrones.state;

public class MaquinaExpendedora {
    private Estado estadoSinMoneda;
    private Estado estadoConMoneda;
    private Estado estadoSinStock;
    // Referencia al estado actual de la máquina
    private Estado estadoActual;
    private int stock;

    public MaquinaExpendedora(int stockInicial) {
        estadoSinMoneda = new EstadoSinMoneda(this);
        estadoConMoneda = new EstadoConMoneda(this);
        estadoSinStock = new EstadoSinInventario(this);

        this.stock = stockInicial;
        estadoActual = (stock > 0) ? estadoSinMoneda : estadoSinStock;
    }

    public void insertarMoneda() {
        estadoActual.insertarMoneda();
    }

    public void expulsarMoneda() {
        estadoActual.expulsarMoneda();
    }

    public void presionarBoton() {
        estadoActual.presionarBoton();
    }

    public void liberarProducto() {
        if (stock > 0) {
            stock--;
            System.out.println("Entregando producto...");
        }

        if (stock == 0) {
            System.out.println("Producto agotado.");
            setEstado(estadoSinStock);
        } else {
            setEstado(estadoSinMoneda);
        }
    }

    public void setEstado(Estado estado) {
        this.estadoActual = estado;
    }

    public Estado getEstadoSinMoneda() {
        return estadoSinMoneda;
    }

    public Estado getEstadoConMoneda() {
        return estadoConMoneda;
    }

    public Estado getEstadoSinStock() {
        return estadoSinStock;
    }
}

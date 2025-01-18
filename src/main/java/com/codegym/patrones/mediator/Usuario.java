package com.codegym.patrones.mediator;

public class Usuario {
    private String nombre;
    private MediadorChat mediador;

    public Usuario(String nombre, MediadorChat mediador) {
        this.nombre = nombre;
        this.mediador = mediador;
        mediador.registrarUsuario(this);
    }

    public void enviarMensaje(String mensaje) {
        System.out.println(nombre + " envía: " + mensaje);
        mediador.enviarMensaje(mensaje, this);
    }

    public void recibirMensaje(String mensaje) {
        System.out.println(nombre + " recibe: " + mensaje);
    }
}

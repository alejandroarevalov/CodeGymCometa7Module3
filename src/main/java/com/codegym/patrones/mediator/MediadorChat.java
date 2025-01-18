package com.codegym.patrones.mediator;

interface MediadorChat {
    void enviarMensaje(String mensaje, Usuario usuario);
    void registrarUsuario(Usuario usuario);
}

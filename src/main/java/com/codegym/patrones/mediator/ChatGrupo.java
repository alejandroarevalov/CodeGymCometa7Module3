package com.codegym.patrones.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatGrupo implements MediadorChat {
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void enviarMensaje(String mensaje, Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u != usuario) { // No enviar el mensaje al remitente
                u.recibirMensaje(mensaje);
            }
        }
    }
}

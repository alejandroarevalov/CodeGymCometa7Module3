package com.codegym.patrones.mediator;

public class Cliente {
    public static void main(String[] args) {
        MediadorChat chat = new ChatGrupo();

        Usuario juan = new Usuario("Juan", chat);
        Usuario maria = new Usuario("María", chat);
        Usuario carlos = new Usuario("Carlos", chat);

        juan.enviarMensaje("Hola, ¿cómo están?");
        maria.enviarMensaje("¡Hola Juan! Estoy bien.");
        carlos.enviarMensaje("¡Saludos a todos!");
    }
}

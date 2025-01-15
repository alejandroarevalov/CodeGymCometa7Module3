package com.codegym.patrones.proxy;

import java.util.HashMap;
import java.util.Map;

public class ProxyServicioBancario implements ServicioBancario {
    private final ServicioBancario servicioReal;
    private final Map<String, String> usuariosAutorizados;

    public ProxyServicioBancario(ServicioBancario servicioBancario) {
        this.servicioReal = servicioBancario;
        this.usuariosAutorizados = new HashMap<>();
        usuariosAutorizados.put("usuario1", "deposito");
        usuariosAutorizados.put("usuario2", "retiro");
    }

    private boolean tienePermiso(String usuario, String tipo) {
        return tipo.equals(usuariosAutorizados.get(usuario));
    }

    @Override
    public void realizarTransaccion(String tipo, double monto) {
        String usuario = obtenerUsuarioActual();
        if (tienePermiso(usuario, tipo)) {
            servicioReal.realizarTransaccion(tipo, monto);
        } else {
            System.out.println("Acceso denegado para el usuario: " + usuario + " en la operación: " + tipo);
        }
    }

    private String obtenerUsuarioActual() {
        // Simula la obtención del usuario actual
        return "usuario1"; // Cambiar según el caso de prueba
    }
}

package com.codegym.logging;

import com.codegym.logging.CalculadoraLogging;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingMain {
    private static final Logger registrador = LogManager.getRootLogger();

    public static void main(String[] args) {
        registrador.trace("Mensajes de depuración pequeños");
        registrador.debug("Mensajes de depuración importantes");
        registrador.info("Mensajes informativos importantes");
        registrador.warn("Mensajes de advertencia");
        registrador.error("Mensajes de error de la aplicación");
        registrador.fatal("Se ha producido un error muy grave. Contacte administradores");

        CalculadoraLogging calculadora = new CalculadoraLogging();
        calculadora.sumar(2, 65);
        calculadora.restar(2, 3);
        calculadora.multiplicar(3, 4);
        calculadora.imprimirTodosLosNivelesDeRegistro();
    }
}

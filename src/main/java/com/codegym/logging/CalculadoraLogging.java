package com.codegym.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculadoraLogging {

    private static final Logger CALCULADORALOGGER = LogManager.getLogger(CalculadoraLogging.class);

    public int sumar(int x, int y) {
        CALCULADORALOGGER.info("Numeros a sumar: {} y {}", x, y);
        return x + y;
    }

    public int restar(int x, int y) {
        CALCULADORALOGGER.info("Se van a restar los numeros {} y {}", x, y);
        return x - y;
    }

    public int multiplicar(int x, int y) {
        CALCULADORALOGGER.debug("Estamos depurando los parametros recibidos: {} y {}", x, y);
        int resultado = x * y;
        CALCULADORALOGGER.info("El resultado despues de ejecutar nuestro complejo metodo es: {}", resultado);
        return resultado;
    }

    public int dividir(int x, int y) {
        return x / y;
    }

    public void imprimirTodosLosNivelesDeRegistro() {
        CALCULADORALOGGER.trace("Mensaje de trazado en " +  this.getClass().getName());
        CALCULADORALOGGER.debug("Mensajes de depuración en {} ", this.getClass().getName());
        CALCULADORALOGGER.info("Mensajes informativos importantes en {} ", this.getClass().getName());
        CALCULADORALOGGER.warn("Mensajes de advertencia en {} ", this.getClass().getName());
        CALCULADORALOGGER.error("Mensajes de error de la aplicación en {} ", this.getClass().getName());
        CALCULADORALOGGER.fatal("Mensajes fatales en {} ", this.getClass().getName());
    }
}

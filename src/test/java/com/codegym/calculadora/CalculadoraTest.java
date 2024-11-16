package com.codegym.calculadora;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    public void ejecutarAntesDeCadaPruebaUnitaria() {
        System.out.println("Vamos a ejecutar una prueba unitaria");
        calculadora = new Calculadora();
    }

    @AfterEach
    public void ejecutarDespuesDeCadaPruebaUnitaria() {
        System.out.println("Prueba ejecutada satisfactoriamente...");
    }

    @ParameterizedTest
    @MethodSource("generarParametrosParaComprobarSumaDeCalculadora")
    @DisplayName("Comprobar que la suma es correcta")
    public void comprobarSumaDeCalculadoraEsCorrecta(int numero1, int numero2, int resultadoEsperado) {
        int resultadoObtenido = calculadora.sumar(numero1, numero2);
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    private static Stream<Arguments> generarParametrosParaComprobarSumaDeCalculadora() {
        return Stream.of(
            Arguments.of(6, 3, 9),
            Arguments.of(-1, 0, -1),
            Arguments.of(-1, -1, -2),
            Arguments.of(5, -3, 2)
        );
    }

    @Test
    public void comprobarRestaDeCalculadoraEsCorrecta() {
        // AAA ->
        // Acomodar: Construir parametros para el metodo a probar y resultados esperados
        // Actuar: Ejecutar el metodo al que quiero probarle su comportamiento especifico
        // Asegurar: Comprobar que el resultado de la ejecucion del metodo a probar concuerde con los resultados esperados
        int resultadoEsperado = -3;
        int resultadoObtenido = calculadora.restar(5, 8);
        assertEquals(resultadoEsperado, resultadoObtenido);
    }
    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Disabled
    public void comprobarMultiplicacionDeCalculadoraEsCorrecta() {
        int resultadoEsperado = 6;
        int resultadoObtenido = calculadora.multiplicar(-3, -2);
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @BeforeAll
    public static void ejecutarAntesQueTodo() {
        System.out.println("ESTO SE EJECUTA ANTES DE CUALQUIER COSA");
    }

    @AfterAll
    public static void ejecutarDespuesDeTodo() {
        System.out.println("ESTO SE EJECUTA DESPUES DE TODO");
    }
}

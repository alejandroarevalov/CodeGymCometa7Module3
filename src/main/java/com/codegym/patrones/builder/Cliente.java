package com.codegym.patrones.builder;

public class Cliente {
    public static void main(String[] args) {

        AutomovilBuilder builder = new AutomovilBuilder();

        // Construir un automóvil deportivo
        Automovil deportivo = builder.setMotor("V8")
            .setRuedas("Deportivas")
            .setColor("Rojo")
            .setMarca("Ferrari")
            .setModelo("F8 Spider")
            .build();
        System.out.println("Automóvil deportivo: " + deportivo);

        // Construir un automóvil familiar
        Automovil familiar = builder.setMotor("V6")
            .setRuedas("Estándar")
            .setColor("Azul")
            .setMarca("Toyota")
            .setModelo("Highlander")
            .build();
        System.out.println("Automóvil familiar: " + familiar);

        // Construir un automóvil básico
        Automovil basico = builder.setMotor("V4")
            .setRuedas("Básicas")
            .setColor("Blanco")
            .setMarca("Nissan")
            .setModelo("Versa")
            .build();
        System.out.println("Automóvil básico: " + basico);
    }
}

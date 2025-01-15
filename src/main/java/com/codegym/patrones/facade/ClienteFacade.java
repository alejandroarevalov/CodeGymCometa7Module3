package com.codegym.patrones.facade;

public class ClienteFacade {
    public static void main(String[] args) {
        // Crear los componentes
        ReproductorDVD reproductorDVD = new ReproductorDVD();
        SistemaDeAudio sistemaDeAudio = new SistemaDeAudio();
        PantallaDeProyeccion pantallaDeProyeccion = new PantallaDeProyeccion();

        // Crear la fachada
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(reproductorDVD, sistemaDeAudio, pantallaDeProyeccion);

        // Usar la fachada para ver una película
        homeTheater.verPelicula();

        // Al finalizar, terminar la película
        homeTheater.terminarPelicula();
    }
}
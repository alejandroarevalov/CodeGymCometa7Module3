package com.codegym.patrones.facade;

public class HomeTheaterFacade {
    private ReproductorDVD reproductorDVD;
    private SistemaDeAudio sistemaDeAudio;
    private PantallaDeProyeccion pantallaDeProyeccion;

    public HomeTheaterFacade(ReproductorDVD reproductorDVD, SistemaDeAudio sistemaDeAudio, PantallaDeProyeccion pantallaDeProyeccion) {
        this.reproductorDVD = reproductorDVD;
        this.sistemaDeAudio = sistemaDeAudio;
        this.pantallaDeProyeccion = pantallaDeProyeccion;
    }

    public void verPelicula() {
        System.out.println("\nPreparando el sistema para ver una película...");
        pantallaDeProyeccion.bajar();
        pantallaDeProyeccion.encender();
        sistemaDeAudio.encender();
        sistemaDeAudio.subirVolumen();
        reproductorDVD.encender();
        reproductorDVD.reproducir();
    }

    public void terminarPelicula() {
        System.out.println("\nTerminando la película...");
        reproductorDVD.pausar();
        sistemaDeAudio.bajarVolumen();
        sistemaDeAudio.apagar();
        pantallaDeProyeccion.apagar();
        reproductorDVD.detener();
    }
}

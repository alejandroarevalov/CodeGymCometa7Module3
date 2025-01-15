package com.codegym.patrones.abstractfactory;

public class TiendaMuebles {
    private FabricaMuebles fabrica;
    private Silla silla;
    private Sofa sofa;
    private Mesa mesa;

    public TiendaMuebles(FabricaMuebles fabrica) {
        this.fabrica = fabrica;
    }

    public void crearMuebles() {
        silla = fabrica.crearSilla();
        sofa = fabrica.crearSofa();
        mesa = fabrica.crearMesa();
    }

    public void mostrarInfoMuebles() {
        System.out.println(silla.sentarse());
        System.out.println(sofa.recostarse());
        System.out.println(mesa.colocarObjeto());
    }

    public static void main(String[] args) {
        TiendaMuebles tiendaModerna = new TiendaMuebles(new FabricaMueblesModernos());
        tiendaModerna.crearMuebles();
        System.out.println("Muebles Modernos:");
        tiendaModerna.mostrarInfoMuebles();

        System.out.println("\nMuebles Vintage:");
        // Crear muebles vintage
        TiendaMuebles tiendaVintage = new TiendaMuebles(new FabricaMueblesVintage());
        tiendaVintage.crearMuebles();
        tiendaVintage.mostrarInfoMuebles();
    }
}
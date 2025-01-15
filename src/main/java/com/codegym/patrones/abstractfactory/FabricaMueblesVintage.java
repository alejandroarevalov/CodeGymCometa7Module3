package com.codegym.patrones.abstractfactory;

public class FabricaMueblesVintage implements FabricaMuebles {
    @Override
    public Silla crearSilla() {
        return new SillaVintage();
    }

    @Override
    public Sofa crearSofa() {
        return new SofaVintage();
    }

    @Override
    public Mesa crearMesa() {
        return new MesaVintage();
    }
}

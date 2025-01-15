package com.codegym.patrones.abstractfactory;

// Fábricas Concretas
public class FabricaMueblesModernos implements FabricaMuebles {
    @Override
    public Silla crearSilla() {
        return new SillaModerna();
    }

    @Override
    public Sofa crearSofa() {
        return new SofaModerno();
    }

    @Override
    public Mesa crearMesa() {
        return new MesaModerna();
    }
}

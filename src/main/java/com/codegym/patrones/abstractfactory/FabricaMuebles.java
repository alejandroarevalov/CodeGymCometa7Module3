package com.codegym.patrones.abstractfactory;

// Fábrica Abstracta
public interface FabricaMuebles {
    Silla crearSilla();
    Sofa crearSofa();
    Mesa crearMesa();
}

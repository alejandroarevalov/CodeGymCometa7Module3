package com.codegym.patrones.state;

interface Estado {
    void insertarMoneda();
    void expulsarMoneda();
    void presionarBoton();
    void dispensar();
}

package com.codegym.memoria;

import java.util.ArrayList;
import java.util.List;

class A {
    String x = "Hola";
}

class B {
  String y = "Mundo";
  A a = new A();
}

public class LiveAndDeathObjects {

    public static void main(String[] args) throws InterruptedException {
        long i = 0;
        List<A> objetosLista = new ArrayList<>();
        while (true) {
            Thread.sleep(50);
            if (i % 10 == 0) {
                new B();
            }
            objetosLista.add(new A());
            i++;
        }
    }
}

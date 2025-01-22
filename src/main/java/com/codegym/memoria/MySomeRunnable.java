package com.codegym.memoria;

public class MySomeRunnable implements Runnable {

    public void run() {
        one();
    }

    public void one() {
        int localOne = 1;

        Shared localTwo = Shared.instance;

        //... do something with local variables

        two();
    }

    public void two() {
        Integer localOne = 2;

        //... do something with local variables
    }
}
package com.codegym.memoria;

public class Main {

    public static void main(String[] args) {
        new Thread(new MySomeRunnable()).start();
        new Thread(new MySomeRunnable()).start();
    }
}

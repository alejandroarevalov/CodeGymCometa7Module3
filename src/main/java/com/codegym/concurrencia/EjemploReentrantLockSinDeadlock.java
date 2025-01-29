package com.codegym.concurrencia;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EjemploReentrantLockSinDeadlock {
    private static final Lock lockA = new ReentrantLock();
    private static final Lock lockB = new ReentrantLock();

    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            boolean gotLockA = false;
            boolean gotLockB = false;

            try {
                // Intentamos obtener los dos bloqueos
                gotLockA = lockA.tryLock();
                gotLockB = lockB.tryLock();

                if (gotLockA && gotLockB) {
                    System.out.println("Hilo 1: Bloqueado recurso A y recurso B");
                    // Simula trabajo con los recursos
                    Thread.sleep(200);
                } else {
                    System.out.println("Hilo 1: No pudo obtener ambos recursos, saliendo...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Solo intentamos desbloquear si ambos bloqueos fueron obtenidos
                if (gotLockA) {
                    lockA.unlock();
                }
                if (gotLockB) {
                    lockB.unlock();
                }
            }
        });

        Thread hilo2 = new Thread(() -> {
            boolean gotLockB = false;
            boolean gotLockA = false;

            try {
                // Intentamos obtener los dos bloqueos
                gotLockB = lockB.tryLock();
                gotLockA = lockA.tryLock();

                if (gotLockB && gotLockA) {
                    System.out.println("Hilo 2: Bloqueado recurso B y recurso A");
                    // Simula trabajo con los recursos
                    Thread.sleep(100);
                } else {
                    System.out.println("Hilo 2: No pudo obtener ambos recursos, saliendo...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Solo intentamos desbloquear si ambos bloqueos fueron obtenidos
                if (gotLockA) {
                    lockA.unlock();
                }
                if (gotLockB) {
                    lockB.unlock();
                }
            }
        });

        hilo1.start();
        hilo2.start();
    }
}
package com.codegym.memoria;

public class VisibilityExample {
    private static class SharedObject {
        private volatile boolean flag = false;

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public boolean getFlag() {
            return flag;
        }
    }

    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hilo escritor: Cambiando la bandera a true");
            sharedObject.setFlag(true);
        });

        Thread readerThread = new Thread(() -> {
            while (!sharedObject.getFlag()) {
                // Puede quedar atrapado aquí
            }
            System.out.println("Hilo lector: Bandera detectada tiene el valor " + sharedObject.getFlag());
        });

        writerThread.start();
        readerThread.start();

        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
package com.codegym.concurrencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EjemploCopyOnWriteList {

    public void concurrentAccessModification() {
        List<String> list = new ArrayList<>();

        // Adding elements to the list
        list.add("One");
        list.add("Two");
        list.add("Three");

        new Thread(() -> {
            for (String s : list) {
                System.out.println("Thread 1: " + s);
            }
        }).start();

        new Thread(() -> {
            list.add("Four");
            System.out.println("Thread 2 added 'Four'");
            list.add("Five");
            System.out.println("Thread 2 added 'Five'");
        }).start();
    }

    public void synchronizedList() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        // Adding elements to the list
        list.add("One");
        list.add("Two");
        list.add("Three");

        // Creating a new thread that reads the list
        new Thread(() -> {
            synchronized (list) { // Synchronize to prevent ConcurrentModificationException
                for (String s : list) {
                    System.out.println("Thread 1: " + s);
                }
            }
        }).start();

        // Creating a new thread that modifies the list
        new Thread(() -> {
            synchronized (list) {
                list.add("Four");
                System.out.println("Thread 2 added 'Four'");
                list.add("Five");
                System.out.println("Thread 2 added 'Five'");
            }
        }).start();
    }

    public void copyOnWriteList() {
        List<String> list = new CopyOnWriteArrayList<>();

        // Adding elements to the list
        list.add("One");
        list.add("Two");
        list.add("Three");

        // Creating a new thread that reads the list
        new Thread(() -> {
            for (String s : list) {
                System.out.println("Thread 1: " + s);
            }
        }).start();

        // Creating a new thread that modifies the list
        new Thread(() -> {
            list.add("Four");
            System.out.println("Thread 2 added 'Four'");
            list.add("Five");
            System.out.println("Thread 2 added 'Five'");
        }).start();
    }

    public static void main(String[] args) {
        EjemploCopyOnWriteList example = new EjemploCopyOnWriteList();
        // example.concurrentAccessModification();
        // example.synchronizedList();
        example.copyOnWriteList();
    }
}

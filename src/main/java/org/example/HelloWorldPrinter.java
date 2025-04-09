package org.example;

public class HelloWorldPrinter implements Runnable {
    public void run() {
        System.out.println("This is thread = " + Thread.currentThread().getName());
        System.out.println("Hello World");
    }
}

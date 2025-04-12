package org.example.synchronizatioonMethod;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);
        Thread thread = new Thread(adder);
        Thread thread2 = new Thread(subtractor);
        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

        System.out.println(count.count);
    }
}

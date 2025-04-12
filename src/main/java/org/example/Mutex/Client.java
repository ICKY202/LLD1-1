package org.example.Mutex;

import java.util.ArrayDeque;
import java.util.Queue;

public class Client {
    public static void main(String[] args) {
        Queue<Object> store = new ArrayDeque<Object>();

        int maxSize = 6;

        Producer producer = new Producer(store, maxSize, "p");
        Producer producer1 = new Producer(store, maxSize, "p2");
        Producer producer2 = new Producer(store, maxSize, "p2");

        Consumer consumer = new Consumer(store, maxSize, "C");
        Consumer consumer1 = new Consumer(store, maxSize, "C1");
        Consumer consumer2 = new Consumer(store, maxSize, "C2");

        Thread thread1 = new Thread(producer);
        thread1.start();
        Thread thread2 = new Thread(producer1);
        thread2.start();
        Thread thread3 = new Thread(producer2);
        thread3.start();

        Thread thread6 = new Thread(consumer);
        thread6.start();
        Thread thread7 = new Thread(consumer1);
        thread7.start();
        Thread thread8 = new Thread(consumer2);
        thread8.start();

        System.out.println(Thread.activeCount());




    }
}

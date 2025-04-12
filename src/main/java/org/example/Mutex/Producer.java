package org.example.Mutex;

import java.util.Queue;

public class Producer implements Runnable {
    Queue<Object> store;
    int maxSize;
    String name;
    public Producer(Queue<Object> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }
    public void run() {
        while(true) {
            synchronized(store) {
                if(store.size() < maxSize) {
                    System.out.println("Producer " + this.name + " is producing " + store.size());
                    store.add(new Object());
                    System.out.println("Thread name is " + Thread.currentThread().getName());
                }
            }
        }
    }
}

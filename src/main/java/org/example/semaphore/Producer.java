package org.example.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    Queue<Object> store;
    int maxSize;
    String name;
    Semaphore semaphoreCon;
    Semaphore semaphorePro;
    public Producer(Queue<Object> store, int maxSize, String name, Semaphore semaphoreCon, Semaphore semaphorePro) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.semaphoreCon = semaphoreCon;
        this.semaphorePro = semaphorePro;
    }
    public void run() {
        while(true) {
            try {
                semaphorePro.acquire();
                System.out.println("Producer " + this.name + " is producing " + store.size());
                store.add(new Object());
                semaphoreCon.release();
                System.out.println("Thread name is " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

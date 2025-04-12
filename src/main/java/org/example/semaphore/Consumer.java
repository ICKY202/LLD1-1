package org.example.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    Queue<Object> store;
    int maxSize;
    String name;
    Semaphore semaphoreCon;
    Semaphore semaphorePro;
    public Consumer(Queue<Object> store, int maxSize, String name, Semaphore semaphoreCon, Semaphore semaphorePro) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.semaphoreCon = semaphoreCon;
        this.semaphorePro = semaphorePro;
    }
    public void run() {
        while(true) {
            try {

                semaphoreCon.acquire();
                System.out.println("Consumer " + this.name + " is consuming " + store.size());
                store.remove();
                semaphorePro.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
     }
}

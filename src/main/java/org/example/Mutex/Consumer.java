package org.example.Mutex;

import java.util.Queue;

public class Consumer implements Runnable {
    Queue<Object> store;
    int maxSize;
    String name;
    public Consumer(Queue<Object> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }
    public void run() {
        while(true) {
            synchronized(store) {
                if(store.size() > 0) {
                    System.out.println("Consumer " + this.name + " is consuming " + store.size());
                    store.remove();
                }
            }
        }
     }
}

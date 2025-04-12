package org.example.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Adder implements Runnable {
    Count count;
    Lock lock = new ReentrantLock();
    public Adder(Count count) {
        this.count = count;
    }

    public void run() {
        synchronized (count) {
            for(int i=0; i<10; i++) {
                lock.lock();
                count.count += 1;
                lock.unlock();
            }
        }

    }
}

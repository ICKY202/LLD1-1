package org.example.synchronizationLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Subtractor implements Runnable {
    Count count;
    Lock lock = new ReentrantLock();
    public Subtractor(Count count) {
        this.count = count;
    }

    public void run() {

        for (int i = 0; i < 1000000; i++) {
            lock.lock();
            count.count -= 1;
            lock.unlock();
        }
    }
}

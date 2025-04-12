package org.example.semaphore;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Object> store = new ArrayDeque<Object>();

        int maxSize = 6;

        Semaphore semaphorePro = new Semaphore(3);
        Semaphore semaphoreCon = new Semaphore(0);

        Producer producer = new Producer(store, maxSize, "p", semaphoreCon, semaphorePro);
        Producer producer1 = new Producer(store, maxSize, "p2", semaphoreCon, semaphorePro);
        Producer producer2 = new Producer(store, maxSize, "p2", semaphoreCon, semaphorePro);

        Consumer consumer = new Consumer(store, maxSize, "C", semaphoreCon, semaphorePro);
        Consumer consumer1 = new Consumer(store, maxSize, "C1", semaphoreCon, semaphorePro);
        Consumer consumer2 = new Consumer(store, maxSize, "C2", semaphoreCon, semaphorePro);

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

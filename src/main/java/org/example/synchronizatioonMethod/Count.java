package org.example.synchronizatioonMethod;

public class Count {
    int count = 0;

    public synchronized void addValue(int value) {
            count = value + 1;
    }
    public int getValue() {
        return count;
    }
}

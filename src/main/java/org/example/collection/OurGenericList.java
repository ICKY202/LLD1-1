package org.example.collection;

import java.util.Iterator;

public class OurGenericList<T> implements Iterable<T>{
    private T[] items;
    private int size;
    public OurGenericList() {
        this.size = 0;
        this.items = (T[]) new Object[100];
    }
    public void addItem(T item) {
        items[size++] = item;
    }
    public T getItemAtIndex(int index) {
        return items[index];
    }

    public Iterator<T> iterator() {
        return new OurGenericListIterator(this);
    }

    private class OurGenericListIterator implements Iterator<T>{
        private final OurGenericList<T> list;
        private int index;
        public OurGenericListIterator(OurGenericList<T> list) {
            this.index = 0;
            this.list = list;
        }
        public boolean hasNext() {
            return index < size;
        }
        public T next() {
            return list.items[index ++];
        }
    }
}

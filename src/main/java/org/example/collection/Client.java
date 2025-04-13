package org.example.collection;

import java.util.Iterator;

public class Client {
    public static void main(String [] args) {
        OurGenericList<Integer> list = new OurGenericList<>();
        list.addItem(1);
        list.addItem(2);
        list.addItem(3);

//        Iterator<Integer> iterable = list.iterator();
//        while(iterable.hasNext()) {
//            System.out.println(iterable.next());
//        }

        for(Object x: list) {
            System.out.println(x);
        }

    }
}

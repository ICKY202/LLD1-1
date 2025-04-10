package org.example.mergeSortMultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(3,5,4,2,1,6,7,9,8);
        ExecutorService executor = Executors.newCachedThreadPool();
        MergeSorter mergeSorter = new MergeSorter(list, executor);

        Future<List<Integer>> future = executor.submit(mergeSorter);

        List<Integer> finalResult = future.get();

        System.out.println(finalResult);

    }
}

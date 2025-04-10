package org.example.mergeSortMultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    List<Integer> listToSort;
    ExecutorService executor;
    public MergeSorter(List<Integer> listToSort, ExecutorService executor) {
        this.listToSort = listToSort;
        this.executor = executor;
    }

    public List<Integer> call() throws Exception {
        int size = listToSort.size();
        if(size <= 1) {
            return listToSort;
        }
        List<Integer> leftSort = new ArrayList<>();
        List<Integer> rightSort = new ArrayList<>();

        for(int i=0; i< size / 2; i++) {
            leftSort.add(listToSort.get(i));
        }
        for(int i=size/2; i < size; i++) {
            rightSort.add(listToSort.get(i));
        }

        System.out.println("Left sort: " + leftSort);
        System.out.println("Right sort: " + rightSort);

        MergeSorter leftMergeSorter = new MergeSorter(leftSort, executor);
        MergeSorter rightMergeSorter = new MergeSorter(rightSort, executor);
        Future<List<Integer>> leftFuture = executor.submit(leftMergeSorter);
        Future<List<Integer>> rightFuture = executor.submit(rightMergeSorter);

        List<Integer> leftResult = leftFuture.get();
        List<Integer> rightResult = rightFuture.get();

        List<Integer> finalResult = new ArrayList<>();
        int i=0, j=0;
        while(i < leftResult.size() && j< rightResult.size()) {
            if(leftResult.get(i) < rightResult.get(j)) {
                finalResult.add(leftResult.get(i));
                i++;
            }else {
                finalResult.add(rightResult.get(j));
                j++;
            }
        }

        while(i < leftResult.size()) {
            finalResult.add(leftResult.get(i));
            i++;
        }
        while(j < rightResult.size()) {
            finalResult.add(rightResult.get(j));
            j++;
        }
        return finalResult;
    }
}

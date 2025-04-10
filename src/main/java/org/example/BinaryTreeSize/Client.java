package org.example.BinaryTreeSize;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        ExecutorService executor = Executors.newCachedThreadPool();
        TreeSizeCalculator treeSizeCalculator = new TreeSizeCalculator(root, executor);
        Future<Integer> result = executor.submit(treeSizeCalculator);

        System.out.println(result.get());

    }
}

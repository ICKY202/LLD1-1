package org.example.BinaryTreeSize;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {
    Node node;
    ExecutorService executor;

    public TreeSizeCalculator(Node root, ExecutorService executor) {
        this.node = root;
        this.executor = executor;
    }

    public Integer call() throws Exception {
        if(node == null) {
            return 0;
        }
        TreeSizeCalculator treeSizeCalculator = new TreeSizeCalculator(node.left, executor);
        TreeSizeCalculator treeSizeCalculator2 = new TreeSizeCalculator(node.right, executor);
        Future<Integer> result = executor.submit(treeSizeCalculator);
        Future<Integer> result2 = executor.submit(treeSizeCalculator2);

        return 1 + result.get() + result2.get();
    }
}

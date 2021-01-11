package br.com.mhbp.datastructure.stack.and.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TreeLevelOrder {

    static class BinaryTreeNode {
        int data;
        BinaryTreeNode left, right;
    }


    static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode tree) {
        List<List<Integer>> result = new ArrayList<>();
        List<BinaryTreeNode> currDepthNodes = new ArrayList<>();
        currDepthNodes.add(tree);

        while (!currDepthNodes.isEmpty()) {

            result.add(currDepthNodes.stream().map( curr -> curr.data).collect(Collectors.toList()));

            currDepthNodes.stream()
                    .map(curr -> Arrays.asList(curr.left, curr.right))
                    .flatMap(List::stream)
                    .filter(c -> c != null)
                    .collect(Collectors.toList());
        }


        return result;
    }
}

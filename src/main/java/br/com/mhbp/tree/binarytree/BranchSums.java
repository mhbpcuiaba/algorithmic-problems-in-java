package br.com.mhbp.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree node1 = new BinaryTree(1);
        BinaryTree node2 = new BinaryTree(2);
        BinaryTree node3 = new BinaryTree(3);
        BinaryTree node4 = new BinaryTree(4);
        BinaryTree node5 = new BinaryTree(5);
        BinaryTree node6 = new BinaryTree(6);
        BinaryTree node7 = new BinaryTree(7);
        BinaryTree node8 = new BinaryTree(8);
        BinaryTree node9 = new BinaryTree(9);
        BinaryTree node10 = new BinaryTree(10);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;



        System.out.println(nodeDepths(node1));
    }
    public static int nodeDepths(BinaryTree root) {
        return nodeDepthsRecursive(root, 0, 0);
    }

    public static int nodeDepthsRecursive(BinaryTree node, int depth, int total) {
        if (node != null) {
          System.out.println("node: " + node.value + ", depth: " + depth);
            int leftSum = nodeDepthsRecursive(node.left, depth + 1, total + depth);
            int rightSum = nodeDepthsRecursive(node.right, depth + 1,total + depth);
            depth += leftSum + rightSum;
            return depth;
        }
        return 0;


    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> result = new ArrayList<>();
        branchSumsRecursive(root, result, 0);
        return result;
    }

    public static void branchSumsRecursive(BinaryTree node, List<Integer> result, int acc) {

        if (node == null) {
            acc += node.value;
            if (node.left == null && node.right == null) {
                result.add(acc);
            } else {
                branchSumsRecursive(node.left, result, acc);
                branchSumsRecursive(node.right, result, acc);
            }
        }

    }

}

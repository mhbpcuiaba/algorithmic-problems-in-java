package br.com.mhbp.binarytree.hackerrank;

public class HeightOfBinaryTree {

    static class Node {
        int data;
        Node left, right;
    }

    static int maxHeight = 0;

    static int height(Node root) {

        calculateRecursive(root, 0);
        return maxHeight - 1;
    }

    private static void calculateRecursive(Node node, int currentHeight) {

        if (node == null) {
            maxHeight = Math.max(maxHeight, currentHeight);
            return ;
        }

        calculateRecursive(node.left, currentHeight + 1);
        calculateRecursive(node.right, currentHeight + 1);
    }
}

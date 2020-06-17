package br.com.mhbp.binarytree.hackerrank;

import java.util.ArrayDeque;
import java.util.HashMap;

public class LevelOrderTraversal {

    static class Node {
        int data;
        Node left, right;
    }

    public static void levelOrder(Node root) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node node = queue.pop();
            System.out.print(node.data + " ");

            if (node.left != null)
                queue.addLast(node.left);

            if (node.right != null)
                queue.addLast(node.right);

        }


    }

}
/**
 *
 */
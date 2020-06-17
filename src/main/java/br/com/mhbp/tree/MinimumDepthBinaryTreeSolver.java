package br.com.mhbp.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBinaryTreeSolver {

    public static void main(String args[] ) throws Exception {
        Node v1 = new Node(1);
        Node v2 = new Node(2);
        Node v3 = new Node(3);
        Node v4 = new Node(4);
        Node v5 = new Node(5);

        v1.left = v2;
        v1.right = v3;
        v2.left = v4;
        v2.right = v5;

        System.out.println(new MinimumDepthBinaryTreeSolver().minimumDeptBinaryTreeRecursive(v1, 0));
    }

    int minimumDeptBinaryTreeRecursive(Node v, int level) {

        if (v == null) return level;
        level++;
        int sizeDepthLeft = minimumDeptBinaryTreeRecursive(v.left, level);
        int sizeDepthRight = minimumDeptBinaryTreeRecursive(v.right, level);
        return sizeDepthLeft < sizeDepthRight ? sizeDepthLeft : sizeDepthRight;

    }

    int minimumDeptBinaryTreeIterative(Node root) {

        if (root == null) throw new IllegalArgumentException("Root cannot be null!");


        int level = 1;

        Queue<QueueItem> queue = new LinkedList<>();
        QueueItem queueItem = new QueueItem(root, 1);
        queue.add(queueItem);


        while (Boolean.FALSE.equals(queue.isEmpty())) {
//            queueItem = queue.peek();
//            queue.remove();
            queueItem = queue.remove();

            if (queueItem.node.left == null && queueItem.node.right == null ) {
                return queueItem.depth;
            }

            if (queueItem.node.left != null) {
                queueItem.node = queueItem.node.left;


            }

            if(queueItem.node.right != null ) {
                queueItem.node = queueItem.node.right;
            }
            queueItem.depth++;
            queue.add(queueItem);
        }

        return 0;
    }



    static class QueueItem {
        Node node;
        int depth;

        public QueueItem(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    static class Node {
        Node left;
        Node right;
        int value;
        public Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Node(int value) {
            this.value = value;
        }

    }
}

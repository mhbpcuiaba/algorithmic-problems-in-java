package br.com.mhbp.datastructure.tree.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversalQithoutRecursion {

    static class BinaryTreeNode<T> {

        T data;
        BinaryTreeNode<T> left, right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    static class NodeAndState {
        BinaryTreeNode<Integer> node;
        Boolean leftNodeVisited;

        public NodeAndState(BinaryTreeNode<Integer> node, Boolean leftSubtreeTraversed) {
            this.node = node;
            this.leftNodeVisited = leftSubtreeTraversed;
        }
    }
    static List<Integer> inOrder(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<NodeAndState> inProcress = new ArrayDeque<>();

        inProcress.addFirst(new NodeAndState(root, false));

        while (!inProcress.isEmpty()) {
            NodeAndState nodeAndState = inProcress.removeFirst();

            if (nodeAndState.node != null) {

                if (nodeAndState.leftNodeVisited) {
                    result.add(nodeAndState.node.data);
                } else {
                    inProcress.addFirst(new NodeAndState(nodeAndState.node.right, false));
                    inProcress.addFirst(new NodeAndState(nodeAndState.node, true));
                    inProcress.addFirst(new NodeAndState(nodeAndState.node.left, false));
                }
            }
        }

        return result;
    }

    static List<Integer> preOrder(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<NodeAndState> inProcress = new ArrayDeque<>();

        inProcress.addFirst(new NodeAndState(root, false));

        while (!inProcress.isEmpty()) {
            NodeAndState nodeAndState = inProcress.removeFirst();

            if (nodeAndState.node != null) {

                if (nodeAndState.leftNodeVisited) {
                    result.add(nodeAndState.node.data);
                } else {
                    inProcress.addFirst(new NodeAndState(nodeAndState.node.right, false));
                    inProcress.addFirst(new NodeAndState(nodeAndState.node.left, false));
                    inProcress.addFirst(new NodeAndState(nodeAndState.node, true)); // it will be popped it up next iteration
                }
            }
        }

        return result;
    }

}

package br.com.mhbp.datastructure.tree.binarytree;

public class KthNodeInTree {

    static class BinaryTreeNode<T> {

        int size;
        T data;
        BinaryTreeNode<T> left, right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    static BinaryTreeNode<Integer> findKthNodeBinaryTree(BinaryTreeNode<Integer> node, int k) {
        BinaryTreeNode<Integer> iter = node;

        while (iter != null) {

            int leftSize = iter.left != null ? iter.left.size : 0;

            if (leftSize + 1 < k) {
                k -= (leftSize + 1);
            } else if (leftSize == k - 1) {
                return iter;
            } else {
                iter = iter.left;
            }
        }
        return null;
    }
}

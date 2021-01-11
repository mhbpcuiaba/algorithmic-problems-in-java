package br.com.mhbp.datastructure.tree.binarytree.bst;

public class KthSmallestItemInBST {

    public BSTNode get(BSTNode node, int k) {

        int n = treeSize(node.left) + 1;

        if (n == k) return node;

        if ( n > k) return  get(node.left, k);
        //now we are looking for k - n, since we discarded the left subtree
        return get(node.right, k);
    }

    private int treeSize(BSTNode node) {
        if (node == null) return 0;

        //size left subtree + size right subtree + 1(node/root)
        return treeSize(node.left) + treeSize(node.right) + 1;
    }

    static class  BSTNode {
        int data;
        BSTNode left;
        BSTNode right;
    }
}

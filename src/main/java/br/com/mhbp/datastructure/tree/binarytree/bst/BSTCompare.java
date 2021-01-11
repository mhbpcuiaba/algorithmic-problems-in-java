package br.com.mhbp.datastructure.tree.binarytree.bst;

public class BSTCompare {

    static boolean compare(BSTNode bst1, BSTNode bst2) {
        if (bst1 == null || bst2 == null) return bst1 == bst2;
        if (bst1.data != bst2.data) return false;
        boolean left = compare(bst1.left, bst2.left);
        boolean right = compare(bst1.right, bst2.right);
        return left && right;
    }
    static class  BSTNode {
        int data;
        BSTNode left;
        BSTNode right;
    }
}

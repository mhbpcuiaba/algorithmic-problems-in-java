package br.com.mhbp.binarytree;

import br.com.mhbp.binarytree.BinaryTreeNode;

public class SumRootToLeaf {

    public static int sumRootToLeaf(BinaryTreeNode<Integer> root) {
        return sumRootToLeafRecursive(root, 0);
    }

    private static int sumRootToLeafRecursive(BinaryTreeNode<Integer> root, int partialSum) {
        if (root == null) return 0;

        partialSum = partialSum * 2 + root.data;

        if (root.left == null && root.right == null) return partialSum;

        return sumRootToLeafRecursive(root.left, partialSum) + sumRootToLeafRecursive(root.right, partialSum) ;

    }
}

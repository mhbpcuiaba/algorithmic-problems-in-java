package br.com.mhbp.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class ComputeLeavesOfBinaryTree {

    List<BinaryTreeNode<Integer>> createListOfLeaves(BinaryTreeNode<Integer> node) {
        ArrayList<BinaryTreeNode<Integer>> leaves = new ArrayList<>();
        addLeavesLeftToRight(node, leaves);
        return leaves;
    }

    private void addLeavesLeftToRight(BinaryTreeNode<Integer> node, ArrayList<BinaryTreeNode<Integer>> leaves) {

        if (node == null) {
            if ( node.left == null && node.right == null) {
                leaves.add(node);

            } else {
                addLeavesLeftToRight(node.left, leaves);
                addLeavesLeftToRight(node.right, leaves);

            }
        }
    }
}

package br.com.mhbp.tree.binarytree;

import java.util.List;

public class ReconstructBinaryTreeFromPreorderTraversalWithMarkers {

    private static Integer subtreeIdx;

    public static BinaryTreeNode<Integer> reconstructPreorder(List<Integer> preorder) {
        subtreeIdx = 0;
        return reconstructPreorderSubTree(preorder);
    }

    private static BinaryTreeNode<Integer> reconstructPreorderSubTree(List<Integer> preorder) {
        Integer subtreekey = preorder.get(subtreeIdx++);

        if (subtreekey == null) return null;

        BinaryTreeNode<Integer> leftSubtree = reconstructPreorderSubTree(preorder);
        BinaryTreeNode<Integer> rightSubtree = reconstructPreorderSubTree(preorder);

        return new BinaryTreeNode<>(subtreekey, leftSubtree, rightSubtree);
    }
}

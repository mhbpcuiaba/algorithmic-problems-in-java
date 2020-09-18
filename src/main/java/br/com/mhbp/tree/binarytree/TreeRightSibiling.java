package br.com.mhbp.tree.binarytree;

public class TreeRightSibiling {

    public static void constructRightSibiling(BinaryTreeNode<Integer> tree) {
        while (tree != null) {
            populateLowerLevelNextField(tree);
            tree = tree.left;
        }
    }

    private static void populateLowerLevelNextField(BinaryTreeNode<Integer> tree) {

        while (tree != null && tree.left != null) {
            tree.left.next = tree.right;

            if (tree.next != null) {
                tree.right.next = tree.next.left;
            }

            tree = tree.next;
        }
    }
}

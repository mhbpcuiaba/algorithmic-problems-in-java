package br.com.mhbp.datastructure.tree.binarytree;

public class SuccessorInTree {

    static BinaryTreeNode<Integer> findSucessor(BinaryTreeNode<Integer> node) {
        BinaryTreeNode<Integer> iter = node;

        if (node.right != null) { // find the leftmost element in node's right subtree
            iter = iter.right;


            while (iter.left != null) iter = iter.left;
            return iter;
        }
        //Find the closest ancestor whose left subtree contains node
        while (iter.parent != null && iter.parent.right == iter) iter = iter.parent;
        return iter.parent;
    }
}

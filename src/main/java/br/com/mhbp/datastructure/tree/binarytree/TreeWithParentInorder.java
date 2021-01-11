package br.com.mhbp.datastructure.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class TreeWithParentInorder {
    static class BinaryTreeNode<T> {

        T data;
        BinaryTreeNode<T> left, right, parent;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    static List<Integer> inorderTraversal(BinaryTreeNode<Integer> node) {
        BinaryTreeNode<Integer> prev = null, next = null , curr = node;
        ArrayList<Integer> result = new ArrayList<>();

        while (curr != null) {

            if (curr.parent == prev) {//we came down to curr from prev


                if (curr.left != null) { //keep going left
                    next = curr.left;

                } else { //Done with left, add curr.data to result and try to go right if right is not empty otherwise go up to parent
                    result.add(curr.data);/***********/
                    next = (curr.right != null) ? curr.right : curr.parent;
                }

            } else if (curr.left == prev) {
                result.add(curr.data);/**********/
                //Done with left, add curr.data to result and try to go right if right is not empty otherwise go up to parent
                next = (curr.right != null) ? curr.right : curr.parent;

            } else {//done with both children
                next = curr.parent;
            }

            prev = curr;
            curr = next;
        }

        return result;

    }
}

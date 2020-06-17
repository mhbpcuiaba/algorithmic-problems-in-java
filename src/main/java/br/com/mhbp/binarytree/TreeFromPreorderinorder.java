package br.com.mhbp.binarytree;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreeFromPreorderinorder {

    static class BinaryTreeNode<T> {

        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
        BinaryTreeNode<T> parent;

        public BinaryTreeNode(T data) {
            this.data = data;
        }

        public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {

            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static BinaryTreeNode<Integer> binaryTreeFromPreorderInorder(List<Integer> preorder, List<Integer> inorder) {


        return helper(preorder, 0, preorder.size(), 0, inorder.size(),
                IntStream.range(0, inorder.size()).boxed().collect(Collectors.toMap(i -> inorder.get(i), i -> i)));
    }

    static BinaryTreeNode<Integer> helper(List<Integer> preorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd,
                                          Map<Integer, Integer> nodeToInorderIdx) {

        if (preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
            return null;
        }

        Integer rootInorderIdx = nodeToInorderIdx.get(preorder.get(preorderStart));
        int left = rootInorderIdx - inorderStart;
        return new BinaryTreeNode<>(preorder.get(preorderStart),
                helper(preorder, preorderStart + 1, preorderStart + 1 +left, inorderStart, rootInorderIdx, nodeToInorderIdx),
                helper(preorder, preorderStart + 1 + left,  preorderEnd, rootInorderIdx + 1, inorderEnd, nodeToInorderIdx)
                );
    }
}

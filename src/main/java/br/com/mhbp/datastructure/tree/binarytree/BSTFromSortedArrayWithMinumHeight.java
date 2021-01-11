package br.com.mhbp.datastructure.tree.binarytree;

import java.util.List;

public class BSTFromSortedArrayWithMinumHeight {

    static BinaryTreeNode<Integer> buildFromPreorderList(List<Integer> list) {

        return helper(list, 0, list.size());
    }

    private static BinaryTreeNode<Integer> helper(List<Integer> list, int start, int end) {

        if (start >= end) return null;
        int mid = start + (end - start) / 2;

        Integer data = list.get(mid);
        BinaryTreeNode<Integer> left = helper(list, start, mid - 1);
        BinaryTreeNode<Integer> right = helper(list, mid + 1, end);
        return new BinaryTreeNode<>(data, left, right);
    }
}

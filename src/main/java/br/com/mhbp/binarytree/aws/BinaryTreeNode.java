package br.com.mhbp.binarytree.aws;

public class BinaryTreeNode<T> {

    T data;
    BinaryTreeNode<T> left, right;

    public BinaryTreeNode(T data) {
        this.data = data;

    }
}

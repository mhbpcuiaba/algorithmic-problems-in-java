package br.com.mhbp.datastructure.tree.redblack;

public interface Tree<T> {
    void insert(T data);
    void remove(T data);
    void inOrderTraverse();
}

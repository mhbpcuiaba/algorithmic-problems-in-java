package br.com.mhbp.datastructure.tree.avl;

import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        IntStream.range(1, 100).forEach(i -> avlTree.insert(i));
        IntStream.range(1, 100).forEach(i -> avlTree.insert(i * -10));
        avlTree.traverse();


        AVLTree avlTreeExFromVideo = new AVLTree();
        avlTreeExFromVideo.insert(10);
        avlTreeExFromVideo.insert(20);
        avlTreeExFromVideo.insert(30);
        avlTreeExFromVideo.insert(40);
        avlTreeExFromVideo.insert(50);
        avlTreeExFromVideo.insert(60);

    }
}

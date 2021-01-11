package br.com.mhbp.datastructure.tree.binarytree.bst;


import java.util.HashMap;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.traversal();
        System.out.println();
        tree.delete(10);
        tree.traversal();
        System.out.println();

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }

    Node root;

    void traversal() {

    }

    //TODO inorder, preorder, posorder

    void inorder() {
        inorder(root);
    }

    private void preorder(Node root) {
        if (root == null) return;

        System.out.println(root.value);
        preorder(root.left);
        preorder(root.right);
    }

    private void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.println(root.value);
        inorder(root.right);
    }

    private void posorder(Node root) {
        if (root == null) return;

        posorder(root.left);
        posorder(root.right);
        System.out.println(root.value);
    }

    void insert(int value) {

        if (root == null) root = new Node(value);
        else {
            insert(root, value);
        }

    }

    void insert(Node node, int value) {

        if (value < node.value) {

            if (node.left != null)
                insert(node.left, value);
            else {
                node.left =new Node(value);
            }

        } else {

            if (node.right != null)
                insert(node.right, value);
            else {
                node.right =new Node(value);
            }
        }
    }
    void delete( int value) {
        if (root == null) return;
        delete(root, value);
    }

    Integer delete(Node n, int value) {
       if (n == null) return null;

       if (n.value == value) { // we have found the node we want to remove

           if (n.left == null && n.right == null) {
               return null;// does not contain this value
           } else if (n.right == null) {
               int v = n.left.value;
               n.left = null;
               return v;
           } else if (n.left == null) {
               int v = n.right.value;
               n.right = null;
               return v;

           } else { //removing item with two children

               Node predecessor = getPredecessor(n.left);
               n.value = predecessor.value;
               n.left = new Node(delete(n.left, predecessor.value));
           }

       } else if (n.value < value) {
           n.right = new Node(delete(n.right, value));
       } else {
           n.left = new Node(delete(n.left, value));
       }

       return n.value;
    }

    //get the greatest item from last sub tree
    private Node getPredecessor(Node node) {
        if (node.right != null) return getPredecessor(node.right);
        System.out.println("Predecessor: " + node.value);
        return node;
    }

    int getMax() {
      return getMax(root);
    }

    int getMax(Node n) {
        if (n.right == null) {
            return n.value;
        }

        return getMax(n.right);
    }
    int getMin() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        return getMin(root);
    }

    private int getMin(Node n) {
        if (root.left == null) return n.value;
        return getMin(n.left);
    }

    Node find(int value) {
        searchInNodes(root, value);
        return null;
    }

    private Node searchInNodes(Node node, int value) {
        if (node.value == value) {
            return node;
        } else if (node.value < value) {

            if (node.right != null)
                return searchInNodes(node.right, value);
        } else {
            if (node.left != null)
            return searchInNodes(node.left, value);
        }

        return null;
    }


}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}

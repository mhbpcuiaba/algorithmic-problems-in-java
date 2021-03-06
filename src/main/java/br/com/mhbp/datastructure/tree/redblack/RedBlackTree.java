package br.com.mhbp.datastructure.tree.redblack;


/*
    Properties

    * Each node is either red or black.
    * The root node is always black.
    * All lead nodes (Null pointers) are black.
    * Every red node must have two black child node and must have a parent black node.
    * Every path from a given node to any of its descendant Null nodes contains the same number of black nodes.
 */
public class RedBlackTree<T extends  Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {

        if (root == null) {
            root = new Node<>(data, null);
        } else {
            insert(data, root);
        }

    }

    private void insert(T data, Node<T> node) {

        if (node.data.compareTo(data) > 0) {
            if (node.left != null) {
                insert(data, node.left);
            } else {
                Node<T> newNode = new Node<>(data, node);
                node.left = newNode;
                // check whether the red black tree properties are violated
                settleViolation(newNode);
            }
        } else {
            if (node.right != null) {
                insert(data, node.right);
            } else {
                Node<T> newNode = new Node<>(data, node);;
                node.right = newNode;
                // check whether the red black tree properties are violated
                settleViolation(newNode);
            }
        }

    }

    @Override
    public void remove(T data) {

    }

    @Override
    public void inOrderTraverse() {
        if (root != null)
            inOrderTraverse(root);
    }

    private void inOrderTraverse(Node<T> node) {
        if (node.left != null)
            inOrderTraverse(node.left);
        System.out.println(node);
        if (node.right != null)
            inOrderTraverse(node.right);
    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.right != null) {
            return getPredecessor(node.right);
        } else {
            return node;
        }
    }

    private boolean isRed(Node<T> node) {
        return NodeColor.RED.equals(node);
    }

    //O (log N)
    private void settleViolation(Node<T> node) {
        Node<T> parent = node.getParent();
        Node<T> grandParent = parent != null ? parent.getParent() : null;
        //we have to check the violations up to the root  node
        while (node != root && isRed(node ) && isRed(parent)) {

            if (parent == grandParent.left) {
                Node<T> uncle = grandParent.right;

                //case 1 and 4 -> recoloring
                if (uncle != null && isRed(uncle)) {
                    grandParent.color = NodeColor.RED;
                    parent.color = NodeColor.BLACK;
                    uncle.color = NodeColor.BLACK;
                    node = grandParent;
                } else {
                    //case 2
                    if (node == parent.right){
                        leftRotation(parent);
                        node = parent;
                        parent = grandParent;
                    } else {
                        rightRotation(grandParent);
                        NodeColor tmpColor = parent.color;
                        parent.color = grandParent.color;
                        grandParent.color = tmpColor;
                        node = parent;
                    }
                }
            }
        }
    }

    private void rightRotation(Node<T> grandParent) {

    }

    private void leftRotation(Node<T> parent) {

    }
}

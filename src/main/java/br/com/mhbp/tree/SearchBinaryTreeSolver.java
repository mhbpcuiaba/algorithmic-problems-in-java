package br.com.mhbp.tree;

public class SearchBinaryTreeSolver {


    public static void main(String args[] ) throws Exception {
        Node v1 = new Node(1);
        Node v2 = new Node(2);
        Node v3 = new Node(3);
        Node v4 = new Node(4);
        Node v5 = new Node(5);

        v1.left = v2;
        v1.right = v3;
        v2.left = v4;
        v2.right = v5;

        System.out.println(search(v1, 1));
    }

    static Node search(Node root, int valueToSearch) {

            if (root == null) return null;

            if (root.value == valueToSearch) {
                return root;
            } else {
                Node foundNode = search(root.left, valueToSearch);

                if (foundNode != null) {
                    return foundNode;
                } else {
                    return search(root.right, valueToSearch);
                }
            }
    }

    static class Node {
        Node left;
        Node right;
        int value;
        public Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", value=" + value +
                    '}';
        }
    }
}

package br.com.mhbp.binarytree;

public class BinaryTreeNodeWithParent<T>  {

    T data;
    BinaryTreeNodeWithParent<T> left, right, parent;


    static BinaryTreeNodeWithParent<Integer> lca(BinaryTreeNodeWithParent<Integer> tree, BinaryTreeNodeWithParent<Integer> node1, BinaryTreeNodeWithParent<Integer> node2) {

        int node1Depth = calculateDepth(node1);
        int node2Depth = calculateDepth(node2);

        /**
        * makes node' as the deeper node in order to simplify the code
        * */
        if (node1Depth < node2Depth) {
            BinaryTreeNodeWithParent<Integer> tmp = node1;
            node1 = node2;
            node2 = tmp;
        }

        /**
         * Ascends from deeper node
         */

        int diff = Math.abs(node1Depth - node2Depth);

        while (diff -- > 0) {
            node1 = node1.parent;
        }

        /**
         * now ascends both nodes until we reach the LCA
         */
        while (node1 != node2) {
            node1 = node1.parent;
            node2 = node2.parent;
        }

        return node1;
    }

    static int calculateDepth(BinaryTreeNodeWithParent<Integer> node) {

        int depth = 0;
        while (node.parent != null) {
            depth++;
            node = node.parent;
        }

        return depth;
    }
}

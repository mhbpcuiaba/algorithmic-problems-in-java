package br.com.mhbp.datastructure.tree.binarytree;


/*
Computing the LCA has important applications. For example, it is an essential calculation
when rendering web pages, specifically when computing the CSS that is applicable
to a particular DOM element
 */
public class LowestCommonAncestor {

    static class Status{
        int numTargetNodesFound;
        BinaryTreeNode<Integer> ancestor;

        public Status(int numTargetNodesFound, BinaryTreeNode<Integer> ancestor) {
            this.numTargetNodesFound = numTargetNodesFound;
            this.ancestor = ancestor;
        }
    }


    static BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root,
                                       BinaryTreeNode<Integer> node1,
                                       BinaryTreeNode<Integer> node2) {

        Status status = lcaHelper(root, node1, node2);
        return status.ancestor;
    }

    /*
    returns an object consisting pf an a node. This int field is 0, 1, 2 depending on how many of {node0, node1}
    are present in th tree.

    If both are present in the tree, when ancestor is assigned to a non-null value, it is the LCA.

    This algorithm is structurally similar to a recursive post order traversal, and the complexities are the same.

    Specifically, the time complexity and space complexity are O(n) and (h), respectively, where h is the height of the tree
     */
    private static Status lcaHelper(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {

        if ( tree == null)  return new Status(0, null);


        //check left
        Status statusLeft = lcaHelper(tree.left, node1, node2);
        if (statusLeft.numTargetNodesFound == 2) {// found both nodes in the left subtree
            return statusLeft;
        }

        Status statusRight = lcaHelper(tree.right, node1, node2);
        if (statusRight.numTargetNodesFound == 2) {// found both nodes in the right subtree
            return statusRight;
        }


        int numTargetNodes = statusLeft.numTargetNodesFound + statusRight.numTargetNodesFound + (tree == node1 ? 1 : 0) + (tree == node2 ? 1 : 0);

        return new Status(numTargetNodes, numTargetNodes == 2 ? tree : null);
    }
}

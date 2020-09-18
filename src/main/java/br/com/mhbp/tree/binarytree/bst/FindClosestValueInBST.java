package br.com.mhbp.tree.binarytree.bst;

public class FindClosestValueInBST {

    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBst(tree, target, Integer.MAX_VALUE - 1);
    }


    public static int findClosestValueInBstIterative(BST tree, int target, int closest) {
        BST currentNode = tree;

        while (currentNode != null) {

            if (Math.abs( target - closest) > Math.abs(target - currentNode.value)) {
                closest = currentNode.value;
            }


            if ( target < currentNode.value && currentNode.left != null) {
                currentNode = currentNode.left;
            } else if (target > currentNode.value && currentNode.right != null) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }


        return closest;
    }

    public static int findClosestValueInBst(BST tree, int target, int closest) {

        if (Math.abs( target - closest) > Math.abs(target - tree.value)) {
            closest = tree.value;
        }


        if ( target < tree.value && tree.left != null) {
            closest = findClosestValueInBst(tree.left, target, closest);
        } else if (target > tree.value && tree.right != null) {
            closest = findClosestValueInBst(tree.right, target, closest);
        }
        return closest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}

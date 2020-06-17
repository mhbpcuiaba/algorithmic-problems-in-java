package br.com.mhbp.binarytree;

public class BinaryTreeNode<T>  {


    public BinaryTreeNode<T> next;
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    BinaryTreeNode<T> parent;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }


    static class ReturnType {
        boolean isPerfect;
        boolean isComplete;
        int size;
        BinaryTreeNode<Integer> rootTree;
    }

    static ReturnType findCompleteBinaryTree(BinaryTreeNode<Integer> node) {
        ReturnType returnType = new ReturnType();

        if (node == null) {
            returnType.isPerfect = true;
            returnType.isComplete = true;
            returnType.size = 0;
            returnType.rootTree = null;
            return returnType;
        }

        ReturnType rtLeft = findCompleteBinaryTree(node.left);
        ReturnType rtRight = findCompleteBinaryTree(node.right);


        // CASE - A
        // If left sub-tree is perfect and right is complete and
        // there height is also same then sub-tree root
        // is also complete binary sub-tree with size equal to
        // sum of left and right subtrees plus one for current root
        if (rtLeft.isPerfect == true && rtRight.isComplete == true
                && calculateHeightBasedOn(rtLeft.size) == calculateHeightBasedOn(rtRight.size))
        {
            rtRight.isComplete = true;

            // If right sub-tree is perfect then
            // root is also perfect
            rtRight.isPerfect = (rtRight.isPerfect ? true : false);
            rtRight.size = rtLeft.size + rtRight.size + 1;
            rtRight.rootTree = node;
            return rtRight;
        }


        // CASE - B
        // If left sub-tree is complete and right is perfect and the
        // height of left is greater than right by one then sub-tree root
        // is complete binary sub-tree with size equal to
        // sum of left and right subtrees plus one for current root.
        // But sub-tree cannot be perfect binary sub-tree.
        if (rtLeft.isComplete == true && rtRight.isPerfect == true
                && calculateHeightBasedOn(rtLeft.size) == calculateHeightBasedOn(rtRight.size))
        {
            rtRight.isComplete = true;
            rtRight.isPerfect = false;
            rtRight.size = rtLeft.size + rtRight.size + 1;
            rtRight.rootTree = node;
            return rtRight;
        }

        // CASE - C
        // Else this sub-tree cannot be a complete binary tree
        // and simply return the biggest sized complete sub-tree
        // found till now in the left or right sub-trees
        rtRight.isPerfect = false;
        rtRight.isComplete = false;
        rtRight.size = Math.max(rtLeft.size, rtRight.size);
        rtRight.rootTree = (rtLeft.size > rtRight.size ? rtLeft.rootTree : rtRight.rootTree);
        return rtRight;
    }

    public static int calculateHeightBasedOn(int numberOfNodes) {
        return (int) Math.ceil( Math.log(numberOfNodes + 1) / Math.log(2)); // we dive by Math.log(2) because Math.log works with base 10.
    }
    //---------------------- BalanceStatusWithHeight
    static class BalanceStatusWithHeight {
        boolean balenced;
        int height;

        public BalanceStatusWithHeight(boolean balenced, int height) {
            this.balenced = balenced;
            this.height = height;
        }
    }


    public static  boolean isBalanced(BinaryTreeNode<Integer> node) {
        BalanceStatusWithHeight bswh = checkBalanced(node);
        return bswh.balenced;
    }

    /*
    if any left sibtree is not height-balqanced we do not height-balanced we do not need to visit the corresponding right subtree.
     */
    private static BalanceStatusWithHeight checkBalanced(BinaryTreeNode<Integer> node) {

        if (node == null) return new BalanceStatusWithHeight(true, -1);


        BalanceStatusWithHeight leftResult = checkBalanced(node.left);

        if (!leftResult.balenced) return leftResult;

        BalanceStatusWithHeight rightResult = checkBalanced(node.right);

        if (!rightResult.balenced) return rightResult;

        boolean balanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height);
        return new BalanceStatusWithHeight(balanced, height);
    }
    //---------------------- End of BalanceStatusWithHeight
    /*
    O(n) since we need to visit n nodes
    Although no memory is explicitly allocated, the function call stack reaches a maximum depth of h,
    the height of the tree

    Recursive algorithms are well-suited to problem on trees.
    Remember to include space implicitly allocated on the function call stack when doing space complexity analysis.
    If each node has a parent field, use it to make your code simpler, and to reduce time and space complexity.

    It's easy to make the mistake of treating a node that has a single child as a leaf.


    A binary tree is said to be height-balanced if for each node in the tree,
    the difference in the height of its left and right subtrees is at most one.
    A perfect binary tree is height-balanced, as is a complete binary tree     */
    public static void treeTraversal(BinaryTreeNode<Integer> root) {

        if (root != null) {

            System.out.println("Pre-order: " +root.data);
            treeTraversal(root.left);
            System.out.println("In-order: " +root.data);
            treeTraversal(root.right);
            System.out.println("Pos-order: " +root.data);
        }
    }

    ////


    public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
        return tree == null || checkIfSubtreesAreSymmetric(tree.left, tree.right);
    }

    private static boolean checkIfSubtreesAreSymmetric(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right) {

        if (left == null && right == null) return true;
        else if(left != null && right != null) {

             return left.data == right.data && checkIfSubtreesAreSymmetric(left.left, left.right) && checkIfSubtreesAreSymmetric(right.left, right.right);
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(7);
        root.left = left;
        root.right = right;

        treeTraversal(root);
    }
}

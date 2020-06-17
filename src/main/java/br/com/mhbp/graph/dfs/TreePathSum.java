package br.com.mhbp.graph.dfs;

import java.util.Stack;

public class TreePathSum {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
    }


    public static boolean hasPath(TreeNode node, int sum) {

        if (node == null) return false;

        if (node.val == sum && node.left == null && node.right == null ) return true;


        return hasPath(node.left, sum - node.val) || hasPath(node.right, sum  - node.val);
    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

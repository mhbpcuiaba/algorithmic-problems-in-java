package br.com.mhbp.datastructure.tree.binarytree.aws;

/**
 * Question: Convert a binary search tree to a sorted double-linked list. We can only change the target of pointers, but cannot create any new nodes.
 * For example, if we input a binary search tree as shown on the left side of the Figure 1, the output double-linked list is shown on the right side.
 *
 * According to the definition of in-order traversal, the sub-tree should be already converted to a sorted list when we reach its root (the node with value 10),
 * and the last node in the sorted list should be the node with the greatest node (the node with value 8).
 *
 * If we link the last node in list to the root node of tree, then the root is the last node in list now.
 *
 * We continue to convert its right sub-tree, and connect the root to the node with its least value.
 *
 * How to convert its left sub-tree and right sub-tree?
 *
 * It should be similar to converting the whole tree. Therefore, we can solve it with recursion.
 */
public class BinarySearchTreaAndDoubleLinkedList {
}

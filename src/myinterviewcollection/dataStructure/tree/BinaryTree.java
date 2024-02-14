/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.dataStructure.tree;

/**
 *
 * @author $ADDAM
 */
public class BinaryTree {
    // Java program for different myinterviewcollection.DataStructure.tree traversals

    /* 
    * Class containing left and right child of current 
    * node and key value
    */
    // Root of Binary Tree 
    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int item) {
            this.value = item;
        }
    }

    public BinaryTree() {
        root = null;
    }

    /* 
     * Given a binary myinterviewcollection.DataStructure.tree, print its nodes according to the "bottom-up" postorder traversal.
     * Left, Right, Root
     */
    public void printPostorder(Node node) {
        if (node == null) {
            return;
        }

        // first recur on left subtree 
        printPostorder(node.left);

        // then recur on right subtree 
        printPostorder(node.right);

        // now deal with the node 
        System.out.print(node.value + " ");
    }

    /* 
     * Given a binary myinterviewcollection.DataStructure.tree, print its nodes in inorder
     * Left, Root, Right
     */
    public void printInorder(Node node) {
        if (node == null) {
            return;
        }

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.value + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* 
     * Given a binary myinterviewcollection.DataStructure.tree, print its nodes in preorder
     * Root, Left, Right
     */
    public void printPreorder(Node node) {
        if (node == null) {
            return;
        }

        /* first print data of node */
        System.out.print(node.value + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions 
    public void printPostorder() {
        printPostorder(root);
    }

    public void printInorder() {
        printInorder(root);
    }

    public void printPreorder() {
        printPreorder(root);
    }

}

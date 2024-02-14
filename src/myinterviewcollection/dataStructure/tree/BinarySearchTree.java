/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.dataStructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Saddam Khan
 */
public class BinarySearchTree {
    
    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        
        Node temp = root;
        while (temp != null) {
            if (temp.value > value) {
                temp = temp.left;
            } else if (temp.value < value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }
    
    /* 
     * Given a binary search myinterviewcollection.DataStructure.tree and a number, inserts a new node with the given number in
     * the correct place in the myinterviewcollection.DataStructure.tree. Returns the new root pointer which the caller should then use
     * (the standard trick to avoid using reference parameters). 
     */
    public Node insert(Node node, int data) {

        // 1. If the myinterviewcollection.DataStructure.tree is empty, return a new, single node
        if (node == null) {
            return (new Node(data));
        } else {

            // 2. Otherwise, recur down the myinterviewcollection.DataStructure.tree
            if (data == node.value) {
                return node;
            } else if (data < node.value) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }

            // return the (unchanged) node pointer 
            return node;
        }
    }

    /* 
     * Given a non-empty binary search myinterviewcollection.DataStructure.tree, return the minimum data value found in that
     * myinterviewcollection.DataStructure.tree. Note that the entire myinterviewcollection.DataStructure.tree does not need to be searched.
     */
    public int minvalue(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return (current.value);
    }
    
    public ArrayList<Integer> breadthFirstSearch() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);
        
        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return results;
    }
    
    /* 
     * Given a binary myinterviewcollection.DataStructure.tree, print its nodes in preorder
     * Root, Left, Right
     * it is also called Depth First Search
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
    
    public void printInorder() {
        printInorder(root);
    }
    
}

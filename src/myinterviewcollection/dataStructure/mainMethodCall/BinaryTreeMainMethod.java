/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.dataStructure.mainMethodCall;

import myinterviewcollection.dataStructure.tree.BinaryTree;

/**
 *
 * @author Saddam Khan
 */
public class BinaryTreeMainMethod implements MainMethodInterface {

    @Override
    public void call() {
        
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTree.Node(1);
        tree.root.left = new BinaryTree.Node(2);
        tree.root.right = new BinaryTree.Node(3);
        tree.root.left.left = new BinaryTree.Node(4);
        tree.root.left.right = new BinaryTree.Node(5);

        System.out.println("\nPreorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
        
        // add new line
        System.out.println();
        
    }
    
}

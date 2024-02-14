/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.dataStructure.mainMethodCall;

import myinterviewcollection.dataStructure.tree.BinarySearchTree;

/**
 *
 * @author Saddam Khan
 */
public class BinarySearchTreeMainMethod implements MainMethodInterface{

    @Override
    public void call() {
        BinarySearchTree bst = new BinarySearchTree(); 
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);

        System.out.println("Root: " + bst.root.value);
        System.out.println("\nRoot->Left: " + bst.root.left.value);
        System.out.println("\nRoot->Right: " + bst.root.right.value);
        
        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(27);
        bst.insert(52);
        bst.insert(82);

        System.out.println("BST Contains 27:");
        System.out.println(bst.contains(27));

        System.out.println("\nBST Contains 17:");
        System.out.println(bst.contains(17));
        
        System.out.println("\nBreadth First Search:");
        System.out.println(bst.breadthFirstSearch());
        
        System.out.println("\nMinimum value of BST is " + bst.minvalue(bst.root));
        
        System.err.println("\nBST in ascending order:");
        bst.printInorder(bst.root);
        
        // add new line
        System.out.println();
        
    }
    
}

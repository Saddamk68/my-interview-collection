/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.dataStructure.mainMethodCall;

import myinterviewcollection.algorithms.search.BinarySearch;

/**
 *
 * @author Saddam Khan
 */
public class BinarySearchMainMethod implements MainMethodInterface {
 
    @Override
    public void call() {
        int[] arr = { 2, 3, 4, 10, 40 };
        System.out.println("Find element index using Binary Search : " + BinarySearch.binarySearch(arr, 10));
        System.out.println("Find element index using Recursion Binary Search : " + BinarySearch.binarySearch(arr, 10));
    }
    
}

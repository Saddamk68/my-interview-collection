/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.dataStructure;

import myinterviewcollection.dataStructure.mainMethodCall.BinarySearchMainMethod;
import myinterviewcollection.dataStructure.mainMethodCall.BinarySearchTreeMainMethod;
import myinterviewcollection.dataStructure.mainMethodCall.BinaryTreeMainMethod;
import myinterviewcollection.dataStructure.mainMethodCall.DoublyLinkedListMainMethod;
import myinterviewcollection.dataStructure.mainMethodCall.LinkedListMainMethod;
import myinterviewcollection.dataStructure.mainMethodCall.MainMethodInterface;
import java.util.Arrays;
import myinterviewcollection.algorithms.sorting.BubbleSort;
import myinterviewcollection.algorithms.sorting.InsertionSort;
import myinterviewcollection.algorithms.sorting.MergeSort;
import myinterviewcollection.algorithms.sorting.SelectionSort;
import myinterviewcollection.algorithms.sorting.QuickSort;

/**
 *
 * @author Saddam Khan
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MainMethodInterface mainObj = new LinkedListMainMethod();
        mainObj.call();
        
        mainObj = new DoublyLinkedListMainMethod();
        mainObj.call();

        int[] array = {3,1,4,2,7};
        System.out.println("Unsorted Array : " + Arrays.toString(array));
        int[] sortedArr =  MergeSort.mergeSortAlgo(array);
        System.out.println("Merge Sorted Array : " + Arrays.toString(sortedArr));
        
        System.out.println("Unsorted Array : " + Arrays.toString(array));
        int[] quickSortArr = array.clone();
        QuickSort.quickSortAlgo(quickSortArr);
        System.out.println("Array after merge sort : " + Arrays.toString(quickSortArr));
        
        System.out.println("Unsorted Array : " + Arrays.toString(array));
        int[] selectionSortArr = array.clone();
        SelectionSort.selectionSortAlgo(selectionSortArr);
        System.out.println("Array after selection sort : " + Arrays.toString(selectionSortArr));

        System.out.println("Unsorted Array : " + Arrays.toString(array));
        int[] bubbleSortArr = array.clone();
        BubbleSort.bubbleSortAlgo(bubbleSortArr);
        System.out.println("Array after bubble sort : " + Arrays.toString(bubbleSortArr));

        System.out.println("Unsorted Array : " + Arrays.toString(array));
        int[] insertionSortArr = array.clone();
        InsertionSort.insertionSortAlgo(insertionSortArr);
        System.out.println("Array after insertion sort : " + Arrays.toString(insertionSortArr));

        mainObj = new BinarySearchMainMethod();
        mainObj.call();
        
        mainObj = new BinarySearchTreeMainMethod();
        mainObj.call();
        
        mainObj = new BinaryTreeMainMethod();
        mainObj.call();
        
    }
    
}

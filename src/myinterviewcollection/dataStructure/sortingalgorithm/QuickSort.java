/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.dataStructure.sortingalgorithm;

/**
 *
 * @author Saddam Khan
 */
public class QuickSort {
    
    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
    
    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex+1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, swapIndex, pivotIndex);
        return swapIndex;
    }
    
    public static void quickSortAlgo(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortAlgo(array, left, pivotIndex-1);
            quickSortAlgo(array, pivotIndex+1, right);
        }
    }
    
    public static void quickSortAlgo(int[] array) {
        quickSortAlgo(array, 0, array.length-1);
    }
    
}

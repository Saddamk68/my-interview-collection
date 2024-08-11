/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.algorithms.sorting;

import java.util.Arrays;

/**
 *
 * @author Saddam Khan
 * O(n log n)
 */
public class MergeSort {
    
    public static int[] merge(int[] left, int[] right) {
        int[] combined = new int[left.length + right.length];
        int index=0, i=0, j=0;
        
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                combined[index] = left[i];
                i++;
            } else {
                combined[index] = right[j];
                j++;
            }
            index++;
        }
        
        while (i < left.length) {            
            combined[index] = left[i];
            index++;
            i++;
        }
        
        while (j < right.length) {
            combined[index] = right[j];
            index++;
            j++;            
        }
        
        return combined;
    }
    
    public static int[] mergeSortAlgo(int[] array) {
        if (array.length == 1) return array;
        
        int midIndex = array.length/2;
        int[] left = mergeSortAlgo(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSortAlgo(Arrays.copyOfRange(array, midIndex, array.length));
        
        return merge(left, right);
    }
    
}

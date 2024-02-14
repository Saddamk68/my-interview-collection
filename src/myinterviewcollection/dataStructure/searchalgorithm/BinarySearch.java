/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.dataStructure.searchalgorithm;

/**
 *
 * @author Saddam Khan
 */

/**
 * Binary Search works with only sorted elements
 * sorting order does not matters here
 */
public class BinarySearch {
    
    public static int binarySearch(int[] arr, int val) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right)/2;
            
            if (arr[mid] == val) 
                return mid;
            else if (arr[mid] > val)
                right = mid-1;
            else 
                left = mid+1;
        }
        return -1;
    }
    
    public static int recurBinarySearch(int[] arr, int val) {
        return recurBinarySearch(arr, val, 0, arr.length-1);
    }
    
    public static int recurBinarySearch(int[] arr, int val, int left, int right) {
        int mid = (left + right)/2;
        
        if (left <= right) {
            if (arr[mid] == val)
                return mid;
            else if (arr[mid] > val)
                return recurBinarySearch(arr, val, left, mid-1);
            else 
                return recurBinarySearch(arr, val, mid+1, right);
        }
        return -1;
    }
    
}

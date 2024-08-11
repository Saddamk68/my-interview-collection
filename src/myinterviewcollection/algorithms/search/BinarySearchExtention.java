/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.algorithms.search;

/**
 *
 * @author saddam
 */
public class BinarySearchExtention {
    
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 9, 0, 1, 2};
        int target = 0;
        int index = SearchInRotatedSortedArray(arr, target);
        System.out.println("Index of " + target + " is: " + index);
        
        index = SearchInRotatedSortedArray(arr, 3);
        System.out.println("Index of " + target + " is: " + index);
    }
    
    /**
     * To find the index of a given value in a rotated sorted array, 
     * you can use a modified version of binary search. 
     * This approach takes advantage of the fact that even though the array is rotated, 
     * it still consists of two sorted subarrays. 
     * 
     * Time Complexity : O(log n).
     */
    public static int SearchInRotatedSortedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the target is found
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Target is in the left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else { // Target is in the right half
                    left = mid + 1;
                }
            }
            // Right half must be sorted
            else {
                // Target is in the right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else { // Target is in the left half
                    right = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
    
    /**
     * Initialization: Start with two pointers, left and right, pointing to the beginning and the end of the array.
     * 
     * Calculate the middle index mid.
     * Check if target equals the middle element nums[mid].
     * 
     * Determine which side of the array is sorted:
     * If the left side is sorted (nums[left] <= nums[mid]), check if the target is in this sorted range.
     * If the right side is sorted, check if the target is in this sorted range.
     * 
     * Adjust the left or right pointers based on the above checks to narrow down the search.
     * Return: If the target is found, return its index; otherwise, return -1.
     */

}

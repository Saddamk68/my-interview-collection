/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.algorithms;

import java.util.Arrays;

/**
 *
 * @author saddam
 */
public class MoveZeroes {
    
    public static void main(String args[]) {
        int[] nums = {0, 0, 1, 2, 0, 3, 0, 0, 0, 13, 15, 12, 0 , 0, 0};
        System.out.println("Given integer array is : " + Arrays.toString(nums));
        int[] nums1 = nums.clone();
        moveZeroesToEnd(nums1);
        System.out.println("Moving zero to the end : " + Arrays.toString(nums1));
        
        int[] nums2 = nums.clone();
        moveZeroesToEndUsingSwap(nums2);
        System.out.println("Moving zero to the end using swap : " + Arrays.toString(nums2));
    }
    
    /**
     * Given an integer array nums, move all 0's to the end of it 
     * while maintaining the relative order of the non-zero elements.
     * Note that you must do this in-place without making a copy of the array.
     */
    public static void moveZeroesToEnd(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
    
    public static void moveZeroesToEndUsingSwap(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
        }
    }
   
}

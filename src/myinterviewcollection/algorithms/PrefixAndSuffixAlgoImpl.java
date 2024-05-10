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
public class PrefixAndSuffixAlgoImpl {

    public static void main(String args[]) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Given integer array is : " + Arrays.toString(nums1));
        System.out.println("Product of all the elements except it's self : " + Arrays.toString(productExceptSelf(nums1)));
        
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Given integer array is : " + Arrays.toString(nums2));
        System.out.println("Product of all the elements except it's self : " + Arrays.toString(productExceptSelf(nums2)));
        
        
        int[] nums3 = {1, 2, 3, 4};
        System.out.println("Given integer array is : " + Arrays.toString(nums3));
        System.out.println("Summation of all the elements except it's self : " + Arrays.toString(summationExceptSelf(nums3)));
        
        int[] nums4 = {-1, 1, 0, -3, 3};
        System.out.println("Given integer array is : " + Arrays.toString(nums4));
        System.out.println("Summation of all the elements except it's self : " + Arrays.toString(summationExceptSelf(nums4)));
        
    }
    
    /**
     * Given an integer array nums, return an array answer such that 
     * answer[i] is equal to the product of all the elements of nums except nums[i].
     */
    public static int[] productExceptSelf(int[] arr) {
        int[] prefixProdArr = prefixProd(arr);
        int[] suffixProdArr = suffixProd(arr);
        
        for (int i=0; i<arr.length; i++) {
            arr[i] = prefixProdArr[i] * suffixProdArr[i];
        }
        return arr;
    }
    
    /**
     * Prefix product is the product of all elements to the left of the current element.
     */
    public static int[] prefixProd(int[] arr) {
        int[] prefixProdArr = new int[arr.length];
        prefixProdArr[0] = 1;
        for (int i=1; i<arr.length; i++) {
            prefixProdArr[i] = prefixProdArr[i-1] * arr[i-1];
        }
        System.out.println("Prefix product : " + Arrays.toString(prefixProdArr));
        return prefixProdArr;
    }
    
    /**
     * Suffix product is the product of all elements to the right of the current element.
     */
    public static int[] suffixProd(int[] arr) {
        int[] suffixProdArr = new int[arr.length];
        suffixProdArr[arr.length-1] = 1;
        for (int i=arr.length-2; i>=0; i--) {
            suffixProdArr[i] = suffixProdArr[i+1] * arr[i+1];
        }
        System.out.println("Suffix product : " + Arrays.toString(suffixProdArr));
        return suffixProdArr;
    }

    /**
     * Given an integer array nums, return an array answer such that 
     * answer[i] is equal to the summation of all the elements of nums except nums[i].
     */
    public static int[] summationExceptSelf(int[] arr) {
        int[] prefixSummationArr = prefixSummation(arr);
        int[] suffixSummationArr = suffixSummation(arr);
        
        for (int i=0; i<arr.length; i++) {
            arr[i] = prefixSummationArr[i] + suffixSummationArr[i];
        }
        return arr;
    }
    
    /**
     * Prefix summation is the summation of all elements to the left of the current element.
     */
    public static int[] prefixSummation(int[] arr) {
        int[] prefixSummationArr = new int[arr.length];
        prefixSummationArr[0] = 0;
        for (int i=1; i<arr.length; i++) {
            prefixSummationArr[i] = prefixSummationArr[i-1] + arr[i-1];
        }
        System.out.println("Prefix summation : " + Arrays.toString(prefixSummationArr));
        return prefixSummationArr;
    }
    
    /**
     * Suffix summation is the summation of all elements to the right of the current element.
     */
    public static int[] suffixSummation(int[] arr) {
        int[] suffixSummationArr = new int[arr.length];
        suffixSummationArr[arr.length-1] = 0;
        for (int i=arr.length-2; i>=0; i--) {
            suffixSummationArr[i] = suffixSummationArr[i+1] + arr[i+1];
        }
        System.out.println("Suffix summation : " + Arrays.toString(suffixSummationArr));
        return suffixSummationArr;
    }

}

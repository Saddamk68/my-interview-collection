/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.algorithms;

/**
 *
 * @author saddam
 */
public class Sort_012 {
    
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1, 0, 0, 2, 2, 2, 2, 0, 2, 1, 0, 2, 0, 1, 2, 2};
        sort(arr);
        printArr(arr);
        
        int[] nums = {3, 6, 8, 0, 5, 9, 1, 4, 2, 7, 3, 0, 5, 2, 6, 4, 7, 8, 9, 1};
        sort_0to9(nums);
        printArr(nums);
    }
    
    /**
     * Dutch National Flag algorithm by Edsger Dijkstra
     * Time Complexity : O(n)
     */
    public static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int i=0, j=0, k=arr.length-1;

        while (j<=k) {
            int temp = 0;
            if (arr[j] == 0) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            } else if (arr[j] == 2) {
                temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                k--;    // we are not incrementing j because it has not been checked
            } else {
                j++;
            }
        }
        return arr;
    }
    
    public static void printArr(int[] arr) {
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    
    /**
     * The counting phase has a time complexity of O(n), where n is the number of elements in the array.
     * The reconstruction phase also has a time complexity of O(n).
     * Therefore, the overall time complexity is O(n), making this approach very efficient.
     * 
     * Time Complexity : O(n)
     */
    public static int[] sort_0to9(int[] arr) {
        int count[] = new int[10];
        for (int num : arr) {
            count[num]++;
        }
        
        int index = 0;
        for (int i=0; i<count.length; i++) {
            while(count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
        return arr;
    }
    
}

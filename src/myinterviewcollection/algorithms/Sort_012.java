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
    
}

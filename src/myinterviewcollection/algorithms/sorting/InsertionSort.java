/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.algorithms.sorting;

/**
 *
 * @author saddam
 */
public class InsertionSort {

    public static void insertionSortAlgo(int[] myArray) {
        for (int i=1; i<myArray.length; i++) {
            int temp = myArray[i];
            int j = i-1;
            while (j > -1 && temp < myArray[j]) {
                myArray[i] = myArray[j];
                myArray[j] = temp;
                j--;
            }
        }
    }
    
}

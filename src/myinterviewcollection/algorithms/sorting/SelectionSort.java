/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.algorithms.sorting;

/**
 *
 * @author saddam
 */
public class SelectionSort {
    
    public static void selectionSortAlgo(int[] myArray) {
        for (int i=0; i<myArray.length-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<myArray.length; j++) {
                if (myArray[minIndex] > myArray[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                    int temp = myArray[minIndex];
                    myArray[minIndex] = myArray[i];
                    myArray[i] = temp;
            }
        }
    }
    
}

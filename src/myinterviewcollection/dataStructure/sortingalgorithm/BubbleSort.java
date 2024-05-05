/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.dataStructure.sortingalgorithm;

/**
 *
 * @author saddam
 */
public class BubbleSort {
    
    public static void bubbleSortAlgo(int[] myArray) {
        int arrLength = myArray.length;
        
        for (int i=0; i<arrLength-1; i++) {
            for (int j=i; j<arrLength; j++) {
                if (myArray[i] > myArray[j]) {
                    int temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
    }
    
}

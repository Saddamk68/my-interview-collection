/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author saddam
 */
public class GenBiggestNumber {
    
    public static void main(String[] args) {
        int[] arr = {8, 9, 7, 50, 54, 60};
//        int[] arr = {0,0,0,0,0};

        String largestNumber = findLargestNumber(arr);
        System.out.println("Largest number formed: " + largestNumber);
    }

    public static String findLargestNumber(int[] arr) {
        // Convert the integer array to a String array
        String[] strArr = Arrays.stream(arr)
                                .mapToObj(String::valueOf)
                                .toArray(String[]::new);

        // Sort the array using a custom comparator
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // Compare based on which concatenation yields a larger number
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // Descending order
            }
        });

        // Handle the case where the array consists of all zeros
        if (strArr[0].equals("0")) {
            return "0";
        }

        // Build the largest number by concatenating sorted strings
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strArr) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }
    
}

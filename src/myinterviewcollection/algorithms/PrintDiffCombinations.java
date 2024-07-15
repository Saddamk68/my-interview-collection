/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.algorithms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author saddam
 */
public class PrintDiffCombinations {

    public static void main(String[] args) {
        String str = "abcde";
        int k = 3;

        System.out.println(generateSequences(str, 3));
        System.out.println(generateCircularSequences(str, 3));
    }

    /**
     * Write a java program to generate the sequences based on the length passed
     * as an input, from the given input string. For example, if the input
     * string is “abc”, and input length is 2, then the output must be {ab, bc}
     * only (only the consecutive sequences allowed) If the input is “abcde” and
     * length is 3, then output must be {abc, bcd, cde}
     */
    public static List<String> generateSequences(String input, int length) {
        List<String> sequences = new ArrayList<>();

        if (input == null || length <= 0 || length > input.length()) {
            return sequences;
        }

        for (int i = 0; i <= input.length() - length; i++) {
            sequences.add(input.substring(i, i + length));
        }

        return sequences;
    }

    /**
     * Write a java program to generate the sequences based on the length passed
     * as an input, from the given input string. For example, if the input
     * string is “abc”, and input length is 2, then the output must be {ab, bc,
     * ca} only (only the consecutive sequences allowed) If the input is “abcde”
     * and length is 3, then output must be {abc, bcd, cde, dea, eab}
     */
    public static List<String> generateCircularSequences(String input, int length) {
        List<String> sequences = new ArrayList<>();

        if (input == null || length <= 0 || length > input.length()) {
            return sequences;
        }
        
        int n = input.length();
        String extendedInput = input + input.substring(0, length - 1); // Extend the input to handle wrapping around
        
        for (int i = 0; i < n; i++) {
            sequences.add(extendedInput.substring(i, i + length));
        }

        return sequences;
    }

}

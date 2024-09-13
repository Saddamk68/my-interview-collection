/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.algorithms;

/**
 *
 * @author saddam
 * 
 * Company : LTI Mindtree
 */
public class PrintAllCombination {
    
    public static void main(String[] arg) {
        String str = "ABC";
        
        permute(str, "");
    }
    
    private static void permute(String str, String permutation) {
        // Base case: If the string is empty, print the permutation
        if (str.isEmpty()) {
            System.out.println(permutation);
            return;
        }

        // Recursive case: iterate over the string and generate permutations
        for (int i = 0; i < str.length(); i++) {
            // Extract the current character
            char currentChar = str.charAt(i);

            // Form a new string by excluding the current character
            String remainingString = str.substring(0, i) + str.substring(i + 1);

            // Recurse with the remaining string and add the current character to the permutation
            permute(remainingString, permutation + currentChar);
        }
    }
    
}

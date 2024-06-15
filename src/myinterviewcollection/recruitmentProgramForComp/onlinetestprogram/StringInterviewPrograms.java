/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.recruitmentProgramForComp.onlinetestprogram;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;

/**
 *
 * @author Saddam Khan
 */
public class StringInterviewPrograms {
    
    //longest substring which does not contains duplicate characters
    public static void longestSubstring(String inputString) {
        //Convert inputString to charArray
        char[] charArray = inputString.toCharArray();

        //Initialization
        String longestSubstring = null;

        int longestSubstringLength = 0;

        //Creating LinkedHashMap with characters as keys and their position as values.
        LinkedHashMap<Character, Integer> charPosMap = new LinkedHashMap<Character, Integer>();

        //Iterating through charArray
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];

            //If ch is not present in charPosMap, adding ch into charPosMap along with its position
            if (!charPosMap.containsKey(ch)) {
                charPosMap.put(ch, i);
            } //If ch is already present in charPosMap, reposioning the cursor i to the position of ch and clearing the charPosMap
            else {
                i = charPosMap.get(ch);

                charPosMap.clear();
            }

            //Updating longestSubstring and longestSubstringLength
            if (charPosMap.size() > longestSubstringLength) {
                longestSubstringLength = charPosMap.size();

                longestSubstring = charPosMap.keySet().toString();
            }
        }

        System.out.println("Input String : " + inputString);

        System.out.println("The longest substring : " + longestSubstring);

        System.out.println("The longest Substring Length : " + longestSubstringLength);
    }

    // this will return the longest even number string present in a sentence
    public static String findLongestEvenNbrStringWithSort(String str) {
        String[] strArr = str.split(" ");
        Arrays.sort(strArr, Comparator.comparing(String::length));
        for (int i = strArr.length-1; i >= 0; i--) {
            if (strArr[i].length()%2 == 0) {
                return strArr[i];
            }
        }
        return null;
    }
    
    public static String findLongestEvenNbrString(String str) {
        String[] strArr = str.split(" ");
        int maxLength = 0;
        String result = "";
        
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].length()%2 == 0 && strArr[i].length() > maxLength) {
                result = strArr[i];
                maxLength = strArr[i].length();
            }
        }
        return result;
    }
    
    // validate the sequence of parantheses to be open closed format eg. {}
    public static boolean isValidParenthesesSeq(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{') {
                count++;
            } else {
                count--;
            }
            // this is an important condition to check weather a right sequence has broken in between
            if (count < 0) 
                return false;
        }
        
        return count == 0;
    }
    
}

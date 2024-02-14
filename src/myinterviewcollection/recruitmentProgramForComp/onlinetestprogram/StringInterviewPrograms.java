/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.recruitmentProgramForComp.onlinetestprogram;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Saddam Khan
 */
public class StringInterviewPrograms {
    
    // this will return the longest even number string present in a sentence
    public static String findLongestEvenNbrString(String str) {
        String[] strArr = str.split(" ");
        Arrays.sort(strArr, Comparator.comparing(String::length));
        for (int i = strArr.length-1; i >= 0; i--) {
            if (strArr[i].length()%2 == 0) {
                return strArr[i];
            }
        }
        return null;
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
            if (count < 0) 
                return false;
        }

        if (count == 0) return true;
        return false;
    }
    
}

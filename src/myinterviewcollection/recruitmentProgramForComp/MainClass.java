/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.recruitmentProgramForComp;

import myinterviewcollection.recruitmentProgramForComp.interviewTestCodes.InterviewTestCodes;
import myinterviewcollection.recruitmentProgramForComp.onlinetestprogram.*;


/**
 *
 * @author $ADDAM
 */
public class MainClass {

    public static void main(String[] args) {
        
        InterviewTestCodes interviewTestCodes = new InterviewTestCodes();
        interviewTestCodes.demo(5);
        interviewTestCodes.demo("Test");
        interviewTestCodes.demo(new ATM());
//        interviewTestCodes.demo(null);  // compiler error due to ambiguty
        
        
        int num = 3539;
        System.out.println(String.format("Arabic number %s wrote in roman as : %s", num,
                ArabicToRoman.arabicToRoman(num)));
        
        ATM atm = new ATM();
        System.out.println("Available amount is : " + atm.getAvailableAmount());
        atm.printMap(atm.map);
        atm.withdraw(5300);
        System.out.println("Available amount is : " + atm.getAvailableAmount());
        
        String str = "Be not afraid of greatness";
        System.out.println(StringInterviewPrograms.findLongestEvenNbrString(str));
        
        str = "{{{}}}{}";
        System.out.println(str + " : " + StringInterviewPrograms.isValidParenthesesSeq(str));
        str = "{}{}{}";
        System.out.println(str + " : " + StringInterviewPrograms.isValidParenthesesSeq(str));
        str = "}{";
        System.out.println(str + " : " + StringInterviewPrograms.isValidParenthesesSeq(str));
        str = "{{}";
        System.out.println(str + " : " + StringInterviewPrograms.isValidParenthesesSeq(str));
        
        Integer[] P = {1, 4, 1};
        Integer[] C = {1, 1, 5};
        MinimumRequiredCars.calculate(P.clone(), C.clone());
        MinimumRequiredCars.moreSimpleApproach(P.clone(), C.clone());
        
        P = new Integer[]{4, 4, 2, 4};
        C = new Integer[]{5, 5, 2, 5};
        MinimumRequiredCars.calculate(P.clone(), C.clone());
        MinimumRequiredCars.moreSimpleApproach(P.clone(), C.clone());
        
        P = new Integer[]{2, 3, 4, 2};
        C = new Integer[]{2, 5, 7, 2};
        MinimumRequiredCars.calculate(P.clone(), C.clone());
        MinimumRequiredCars.moreSimpleApproach(P.clone(), C.clone());
        
        System.out.println("Van-Eck Sequence is : " + VanEckSequence.generateVanEckSequence(100));

        OnlineTestProgram.printNumOnSheet();
        System.out.println("");
        
        OnlineTestProgram.duplicateNum();
        System.out.println("");
        
//        VendingMachineClass.runVendingMachine();
//        System.out.println("");

        //longest substring which does not have duplicates
        StringInterviewPrograms.longestSubstring("javaconceptoftheday");
        System.out.println("");
        
        StringInterviewPrograms.longestSubstring("thelongestsubstring");
        System.out.println("");
        
        int[] arr = {1, 3, 6, 4, 2};
        int missingNbr = FindMissingSmallestPosNbr.findMissingNbr(arr, arr.length);
        System.out.println(String.format("Missing smallest positive number is : %s", missingNbr));
        
        int[] negArr = {-1, -3};
        missingNbr = FindMissingSmallestPosNbr.findMissingNbr(negArr, negArr.length);
        System.out.println(String.format("Missing smallest positive number is : %s", missingNbr));
        
    }

}

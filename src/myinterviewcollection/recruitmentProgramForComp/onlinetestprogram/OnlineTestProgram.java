/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.recruitmentProgramForComp.onlinetestprogram;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author $ADDAM
 */
public class OnlineTestProgram {

    /**
     * @param args the command line arguments
     */
    
    private static final int sheetCount = 4;    
    
    public static void printNumOnSheet() {        
        
        int totalPage = 8;
        int remd = 0, divd = 0;
        
        remd = totalPage%sheetCount;
        divd = totalPage/sheetCount;
        
//        System.out.println("remd = " + remd + " & divd = " + divd);
        System.out.print("Printing page number on a sheet : ");
        
        int sheetNo = 0;
        for (int j = 1; j <= divd; j++) {
            sheetNo = j*sheetCount;
            System.out.print(sheetNo + " ");
            for (int i = 3; i > 0; i--) {
                System.out.print(sheetNo - i + " ");
            }
        }
        int count = 3;
        while (remd > 0) {
            System.out.print(sheetCount * (divd + 1) - count + " ");
            count--;
            remd--;
        }
    }

    public static void duplicateNum() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < 30; i++) {
            numbers.add(i);
        }
        //add duplicate number into the list
        numbers.add(22);
        System.out.println("Duplicate Number is : " + findDuplicateNum(numbers));
    }
    
    private static int findDuplicateNum(List<Integer> numbers) {
        int highestNumber = numbers.size() - 1; // not generic
        int total = getSum(numbers);
        int duplicate = total - (highestNumber*(highestNumber+1)/2);
        return duplicate;
    }
     
    private static int getSum(List<Integer> numbers){
        int sum = 0;
        for(int num:numbers){
            sum += num;
        }
        return sum;
    }
    
}

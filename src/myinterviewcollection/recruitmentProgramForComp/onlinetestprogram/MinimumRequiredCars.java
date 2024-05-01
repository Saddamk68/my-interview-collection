/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.recruitmentProgramForComp.onlinetestprogram;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Saddam Khan
 */
public class MinimumRequiredCars {

    public static void calculate(Integer[] P, Integer[] C) {
        Arrays.sort(P, Collections.reverseOrder());
        Arrays.sort(C, Collections.reverseOrder());

        int i = 0, j = 0, carry = 0;
        boolean pFlag = false;
        LoopC:
        for (; j < C.length; j++) {
            pFlag = false;
            LoopP:
            for (; i < P.length; i++) {
                pFlag = true;
                C[j] = C[j] - (P[i] + carry);
                if (C[j] > 0) {
                    continue LoopP;
                } else {
                    carry = Math.abs(C[j]);
                    i++;
                    continue LoopC;
                }
            }
            if (i == P.length) {
                break LoopC;
            }
        }
        System.out.println(String.format("Minimum number of car's required for trip are : %d", pFlag ? j + 1 : j));
    }
    
    public static void moreSimpleApproach(Integer[] P, Integer[] C) {
        int totalPersons = Arrays.stream(P).mapToInt(Integer::intValue).sum();
        Arrays.sort(C, Collections.reverseOrder());
        int i = 0;
        
        while (totalPersons > 0) {
            totalPersons -= C[i];
            i++;
        }
        System.out.println(String.format("Minimum number of car's required for trip are : %d", i));
    }

}

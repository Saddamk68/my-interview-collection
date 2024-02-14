/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.recruitmentProgramForComp.onlinetestprogram;

import java.util.Arrays; 
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Saddam Khan
 */
enum RomanNumeral {
    I(1), IV(4), V(5), IX(9), X(10), 
    XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);

    private final int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static List<RomanNumeral> getReverseSortedValues() {
        return Arrays.stream(values())
          .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
          .collect(Collectors.toList());
    }
    
}

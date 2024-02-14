/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.recruitmentProgramForComp.onlinetestprogram;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Saddam Khan
 */
public class VanEckSequence {
    
    public static String generateVanEckSequence(int range) {
        String str = "";
        int nextSeqNbr = 0;
        int distance = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < range; i++) {
            if (map.containsKey(nextSeqNbr)) {
                distance = i - map.get(nextSeqNbr);
            } else {
                distance = 0;
            }
            map.put(nextSeqNbr, i);
            str += (i == 0 ? nextSeqNbr + "" : ", " + nextSeqNbr);
            nextSeqNbr = distance;
        }
        return str;
    }
}

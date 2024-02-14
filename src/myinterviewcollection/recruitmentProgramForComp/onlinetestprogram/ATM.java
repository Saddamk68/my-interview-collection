/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.recruitmentProgramForComp.onlinetestprogram;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Saddam Khan
 */
public class ATM {

    public final LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    
    public ATM() {
        map.put(2000, 2);
        map.put(500, 5);
        map.put(100, 10);
    }
    
    public int getAvailableAmount() {
//        return map.values().stream().mapToInt(i->i).sum();

        int avlbAmt = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            avlbAmt += entry.getValue()*entry.getKey();
        }
        return avlbAmt;
    }
    
    public void printMap(HashMap<Integer, Integer> map) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(String.format("%s rupees note are : %s", entry.getKey(), entry.getValue()));
        }        
    }
    
    public boolean isValidAmount(int amount) {
        boolean isValidAmt = amount%100 == 0 && amount > 0 ? true : false;
        if (!isValidAmt) {
            System.out.println("Entered amount is invalid");
        }
        return isValidAmt;
    }
    
    public boolean validateWithdrawlAmt(int amount) {
        if (isValidAmount(amount)) {
            boolean isValidWithdrawlAmt = amount < getAvailableAmount() ? true : false;
            if (!isValidWithdrawlAmt) {
                System.out.println("Insuficient balance");
            }
            return isValidWithdrawlAmt;
        }
        return false;
    }
    
    public void withdraw(int amount) {
        if (validateWithdrawlAmt(amount)) {
            int tempAmount = amount;
            HashMap<Integer, Integer> tempMap = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() * entry.getValue() > 0 && tempAmount > 0) {
                    int count = tempAmount/entry.getKey();
                    tempMap.put(entry.getKey(), count);
                    map.put(entry.getKey(), entry.getValue()-count);
                    tempAmount -= count*entry.getKey();
                }
            }
            System.out.println("\nWithdrawl amount is " + amount + " rupees and details are below");
            printMap(tempMap);
        }
    }
    
}

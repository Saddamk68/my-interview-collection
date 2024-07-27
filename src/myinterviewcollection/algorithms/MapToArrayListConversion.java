/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author saddam
 */
public class MapToArrayListConversion {
    
    public static void main(String[] args) {        
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");

        System.out.println("Map to list conversion");
        
        ArrayList<String> valList = new ArrayList<>(map.values());
        System.out.println("Map values to array list : " + valList);
        
        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        System.out.println("Map keys to array list : " + keyList);
        
        ArrayList<Map.Entry<Integer, String>> entriesList = new ArrayList<>(map.entrySet());
        System.out.println("Map keys to array list : " + entriesList);
        
        
        System.out.println("\nMap to list conversion via java8 stream functionality");
        
        ArrayList<String> streamValList = map.values().stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Map values to array list : " + streamValList);
        
        ArrayList<Integer> streamKeyList = map.keySet().stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Map keys to array list : " + streamKeyList);
        
        ArrayList<Map.Entry<Integer, String>> streamEntriesList = map.entrySet().stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Map keys to array list : " + streamEntriesList);
        
    }
    
}

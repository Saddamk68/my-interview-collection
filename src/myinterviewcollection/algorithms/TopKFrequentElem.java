/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author saddam
 */
public class TopKFrequentElem {
    
    public static void main(String args[]) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4};
        System.out.println("Given integer array is : " + Arrays.toString(nums));
        System.out.println("Top k frequent element in given integer array : " 
                + Arrays.toString(topKFrequent(nums, 2)));
        System.out.println("Top k frequent element in given integer array using stream : " 
                + Arrays.toString(topKFrequentUsingStream(nums, 2)));
    }
    
    /**
     * Given an integer array nums and an integer k, return the k most frequent elements.
     * You may return the answer in any order.
     * 
     * Time Complexity : the time complexity of below method is nlog(n) because of .sorted() method 
     */
    public static int[] topKFrequentUsingStream(int[] nums, int k) {
        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed() // to convert int to Integer
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
    
    // the time complexity of below method is O(n)
    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num,0) + 1);
        }
        for (int key : hm.keySet()) {
            int freq = hm.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] ans = new int[k];
        int pos = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size() && pos < k; j++) {
                    ans[pos] = bucket[i].get(j);
                    pos++;
                }
            }
        }
        return ans;
    }
    
}

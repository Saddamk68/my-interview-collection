/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.epam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Saddam Khan
 */
public class Epam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] numbers = {1, 3, 4, 5, 78, 9};
        System.out.println("Matched indices are : " + Arrays.toString(findMatchedIndices(numbers, 13)));

        String[] strArr = {"jaVa", "Spring", "Microservices", "java", "SqL", "Java", "cLoud", "spring"};
        countOccurrence(strArr);
//        countDuplicates(strArr);

        List<Integer> intList = Arrays.asList(10, 15, 8, 49, 25, 98, 12);
        filterUsingStartWith(intList);

        System.out.println("Non-repeated first character from a string is : " + nonRepeatedCharecter("Ava"));

        System.out.println(test(0));
        System.out.println(test(1));

        System.out.println("Sort list using stream functionality : " + sortList(intList));
        System.out.println("Multiply each element of list : " + multiplyEachElement(intList, 3));
        
    }

    public static int[] findMatchedIndices(int[] numArr, int sumElem) {
//        System.out.println("Executing findMatchedIndices method");

        for (int i = 0; i < numArr.length - 1; i++) {
            for (int j = i + 1; j < numArr.length; j++) {
                if (sumElem == numArr[i] + numArr[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void countOccurrence(String[] strArr) {
//        System.out.println("Executing countOccurrence method");

        Map<String, Long> map = Arrays.stream(strArr)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.forEach((key, count) -> {
            System.err.println(key + " : " + count);
        });
    }

    public static void countDuplicates(String[] strArr) {
//        System.out.println("Executing countDuplicates method");

        HashMap<String, Integer> map = new HashMap<>();
        List<String> strList = Arrays.asList(strArr);

        strList.forEach(str -> {
            String tepStr = str.toLowerCase();
            if (map.containsKey(tepStr)) {
                map.put(tepStr, map.get(tepStr) + 1);
            } else {
                map.put(tepStr, 1);
            }
        });

//        map.entrySet().forEach(entry -> {
        for (Map.Entry entry : map.entrySet()) {
            System.err.println(entry.getKey() + " : " + entry.getValue());
        }
//        });
    }

    public static void filterUsingStartWith(List<Integer> intList) {
//        System.out.println("Executing filterUsingStartWith method");

        intList.stream().map(s -> s + "").filter(s -> s.startsWith("1")).forEach(System.out::println);
    }

    public static char nonRepeatedCharecter(String str) {
//        System.out.println("Executing nonRepeatedCharecter method");

        return str.chars()
                .mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
    }

    public static int test(int i) {
        try {
            if (i == 0) {
                throw new Exception();
            }
            return 0;
        } catch (Exception e) {
            return 1;
        } finally {
            return 2;
        }
    }
    
    public static List<Integer> sortList(List<Integer> intList) {
        return intList.stream().sorted().collect(Collectors.toList());
    }
    
    public static List<Integer> multiplyEachElement(List<Integer> intList, int val) {
        return intList.stream().map(num -> num * val).collect(Collectors.toList());
    }

}

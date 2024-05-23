/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author saddam
 */
public class Java8FeaturesImpl {

    /**
     * @company : Epam
     * @implementedFuntions : groupingBy() count number of times any string
     * occurs in a sentence | ignore case
     */
    public void countOccurrence(String[] strArr) {
        Map<String, Long> map = Arrays.stream(strArr)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.forEach((key, count) -> {
            System.err.println(key + " : " + count);
        });
    }

    /**
     * @company :
     * @implementedFuntions : map(), filter() filter list of integer and find
     * the elements starts with 1
     */
    public void filterUsingStartWith(List<Integer> intList) {
        intList.stream()
                .map(s -> s + "")
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);
    }

    /**
     * @company :
     * @implementedFuntions : mapToObj, groupingBy(), LinkedHashMap, findFirst()
     * sort integer list to ASC order
     */
    public List<Integer> sortList(List<Integer> intList) {
        return intList.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * @company :
     * @implementedFuntions : mapToObj, groupingBy(), LinkedHashMap, findFirst()
     * multiply each element of the list to given value
     */
    public List<Integer> multiplyEachElement(List<Integer> intList, int val) {
        return intList.stream()
                .map(num -> num * val)
                .collect(Collectors.toList());
    }

    /**
     * @company :
     * @implementedFuntions : mapToObj, groupingBy(), LinkedHashMap, findFirst()
     * find first non repeated character from a string
     */
    public char nonRepeatedCharecter(String str) {
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

    /**
     * @company : Epam
     * @implementedFuntions : sorted, reverseOrder, Comparator.comparing(),
     * reversed, compareTo(), limit we have a Order class with fields like
     * name(String) and orderDate(LocalDate) find the recent three orders
     */
    public void findRecentThreeOrders() {
        List<Order> recentOrders = getOrderListData().stream()
                //                .sorted(Collections.reverseOrder(Comparator.comparing(Order::getOrderDate)))
                //                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .sorted((ord1, ord2) -> ord2.getOrderDate().compareTo(ord1.getOrderDate()))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Recent Orders:");
        recentOrders.forEach(order -> System.out.println("Date: " + order.getOrderDate()
                + ", Name: " + order.getName()));
    }

    /**
     * @company :
     * @implementedFuntions : filter find sum of dollar amount from a sentence
     */
    public void findSumOfAmountFromGivenString(String str) {
        int sum[] = new int[1];
        Arrays.stream(str.split(" "))
                .filter(s -> s.contains("$"))
                .forEach(s -> {
                    String r = s.substring(s.indexOf('$') + 1);
                    r = r.replace(",", "").replace(".", "");
                    sum[0] += Integer.valueOf(r);
                });
        System.out.println("Sum of the dollar amount present in a sentence is : " + sum[0]);
    }

    /**
     * @company :
     * @implementedFuntions : max, Comparotor.comparingInt() find max length
     * word from a given sentence
     */
    public String findMaxLengthWordFromGivenString(String str) {
        return Arrays.stream(str.split(" "))
                .max(Comparator.comparingInt(String::length))
                .get();
//        return Arrays.stream(strDollar.split(" "))
//                .max((s1, s2) -> s1.length() - s2.length())
//                .get();
    }

    /**
     * @company :
     * @implementedFuntions : sorted, reverseOrder() find max length word from a
     * given sentence
     */
    public void sortGivenStringUsingStream(String str) {
        System.out.println("Sort string list in dcending order : ");
        Arrays.stream(str.split(" "))
                .sorted(Collections.reverseOrder(Comparator.comparing(String::length)))
                .forEach(System.out::println);
    }

    /**
     * @company :
     * @implementedFuntions : boxed(), Arrays.stream(), partitioningBy() filter
     * even and odd from integer array
     */
    public void filterOddEvenNumber(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        Map<Boolean, List<Integer>> result = list.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println("Even numbers are : " + result.get(true));
        System.out.println("Odd numbers are : " + result.get(false));
    }

    /**
     * @company :
     * @implementedFuntions : mapToInt(), sum() find sum of an integer list
     */
    public int findSumOfIntegerList(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * @company :
     * @implementedFuntions : filter() remove duplicates using stream
     * functionality
     */
    public void removeDuplicates(List<Integer> list) {
        HashSet<Integer> set = new HashSet();
        System.out.println("After removing duplicate values : ");
        list.stream()
                .filter(num -> set.add(num))
                .forEach(System.out::println);
    }

    /**
     * @company :
     * @implementedFuntions : filter() find duplicates using stream
     * functionality
     */
    public void findDuplicates(List<Integer> list) {
        HashSet<Integer> set = new HashSet();

        System.out.println("Duplicate values are : ");
        list.stream()
                .filter(num -> !set.add(num))
                .forEach(System.out::println);
    }

    /**
     * @company :
     * @implementedFuntions : max() find max value using stream functionality
     */
    public void findMaxValueFromIntegerList(List<Integer> list) {
        Integer maxNum = list.stream()
                .max(Integer::compare)
                .get();
//        Integer maxNum = list.stream()
//                .max((n1, n2) -> n1-n2)
//                .get();
        System.out.println("Max value is : " + maxNum);
    }

    /**
     * @company :
     * @implementedFuntions : map(), filter() find the cube of each element of
     * the list not greater than 50
     */
    public void findCubeOfIntegerListNotGreaterThan50(List<Integer> list) {
        list.stream()
                .map(n -> n * n * n)
                .filter(num -> num > 50)
                .forEach(System.out::println);
    }

    /**
     * @Data : creating dummy data
     */
    public List<Order> getOrderListData() {
        List<Order> ordList = new ArrayList<>();

        ordList.add(new Order("h", LocalDate.parse("2024-03-01")));
        ordList.add(new Order("b", LocalDate.parse("2024-03-02")));
        ordList.add(new Order("g", LocalDate.parse("2024-03-03")));
        ordList.add(new Order("f", LocalDate.parse("2024-03-04")));
        ordList.add(new Order("c", LocalDate.parse("2024-03-05")));

        return ordList;
    }

}

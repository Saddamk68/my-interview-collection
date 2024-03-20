/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.test;

import com.sun.org.apache.xpath.internal.operations.Operation;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author $ADDAM
 */
interface PrintNumber {

    public void print(int num1);
}

public class Test {

    public static void main(String args[]) {

        int num1 = 11;
        int num2 = num1;
        num1 = 22;
        // java follows pass by value architecture not pass by reference
        System.out.println("num1 is : " + num1);
        System.out.println("num2 is : " + num2);

        
//        B b = (B) new A();
//        b.fly();
//        A a = (B) new B();
//        a.fly();
//        a.eat();
        A a = (A) new B();  // it will work without type casting also
        a.eat();
        a.sleep();

        
        // find sum of dollar amount
        int sum[] = new int[1];
        String strDollar = "#1 Tickets $50,000 Received $40. Expenses $800 . Cheque$2,00,000.";
//        System.out.println(strDollar.substring(0, strDollar.length()-1));
        Arrays.stream(strDollar.split(" ")).filter(s -> s.contains("$"))
                .forEach(s -> {
                    String r = s.substring(s.indexOf('$') + 1);
                    r = r.replace(",", "").replace(".", "");
                    sum[0] += Integer.valueOf(r);
                });
        System.out.println("Sum of the dollar amount present in a sentence is : " + sum[0]);
        String maxStr = Arrays.stream(strDollar.split(" ")).max(Comparator.comparingInt(String::length)).get();
//        String maxStr = Arrays.stream(strDollar.split(" ")).max((s1, s2) -> s1.length() - s2.length()).get();
        System.out.println("Max length string is : " + maxStr);
        System.out.println("Sort string list in dcending order : ");
        Arrays.stream(strDollar.split(" "))
                .sorted(Collections.reverseOrder(Comparator.comparing(String::length)))
                .forEach(System.out::println);
//                .collect(Collectors.toList());
        
        
        // filte even and odd from integer array using stream functionality
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 2, 7, 7, 6};
        List<Integer> list = Arrays.asList(arr);
        Map<Boolean, List<Integer>> result = list.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
//        list.stream().filter(num -> num%2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("Even numbers are : " + result.get(true));
        System.out.println("Odd numbers are : " + result.get(false));
        
        
        // remove duplicates using stream functionality
        HashSet<Integer> set = new HashSet();
        System.out.println("Duplicate values are : ");
        list.stream().filter(num -> !set.add(num)).forEach(System.out::println);
        System.out.println("After removing duplicate values : ");
//        set.clear();
//        list.stream().filter(num -> set.add(num)).forEach(System.out::println);
        set.stream().forEach(System.out::println);

        
        // find max value using stream functionality
        Integer maxNum = list.stream().max(Integer::compare).get();
//        Integer maxNum = list.stream().max((n1, n2) -> n1-n2).get();
        System.out.println("Max value is : " + maxNum);

        list.stream().map(n -> n * n * n).filter(num -> num > 50).forEach(System.out::println);

        
        // validate palindrome
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Palindrome Converter");
        System.out.print("Enter in what you want Palindromeinated ==> ");
        String palin = input.nextLine();
        System.out.println("The origional was: " + palin);

        palin = palin.toLowerCase();
        int length = palin.length();

        char[] tempCharArray = new char[length];
        char[] charArray = new char[length];

        for (int i = 0; i < length; i++) {
            tempCharArray[i] = palin.charAt(i);
        }

        for (int k = 0; k < length; k++) {
            charArray[k] = tempCharArray[length - 1 - k];
        }

        String reversePalin = new String(charArray);
        String reverseNewPalin = "";
        reverseNewPalin = reversePalin.replaceAll("[^A-Za-z0-9]", "");

        System.out.println("The reversed word is: " + reverseNewPalin);

        if (reversePalin.equals(palin)) {
            System.out.println("This is a palindrome!");
        } else {
            System.out.println("This is not a palindrome!");
        }

//        //{1,2,3,4,5,6,7,8,9,10};
//        List<Integer> intArr = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
////        intArr.add(1);
////        int[1] count = {0};
////        List<Integer> count = new ArrayList<>();
////        count.ad
//        intArr.stream().forEach(num -> {
//            if (num%2 == 0) {
//                System.out.println(num*num);
//            }
//        });
        List<String> strArr = Arrays.asList("welcome saddam welcome for the interview");
        List<String> strList = Arrays.asList(strArr.get(0).split(" "));
        HashSet<String> strSet = new HashSet<>();

        strList.stream().forEach(s -> {

            strSet.add(s);

        });
        strList.stream().forEach(s -> {
            if (strSet.contains(s)) {
                System.out.print(s + " ");
            }
        });

////        11,6,89,0,34
//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(11);
//        integerList.add(6);
//        integerList.add(89);
//        integerList.add(0);
//        integerList.add(34);
//        
//        List<Integer> sortedList = integerList.stream().sorted().collect(Collectors.toList());
//        
//        Double str = OnlineTestCode.findDollarAmount();
//        System.out.println(str);
//        
//        
//
//        PrintNumber p = n -> System.out.println("square is: " + Math.sqrt(n));
//        p.print(25);
//
//        FileReader fileRead;
//        String textStr = "";
//        try {
//            fileRead = new FileReader("S:\\jsonFile.txt");
//            int r;
//            try {
//                while ((r = fileRead.read()) != -1) {
//                    textStr += (char) r;
//                }
//                fileRead.close();
//            } catch (IOException ex) {
//                Logger.getLogger("Error while executing while loop : ", ex.getMessage());
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger("Error occure while reading a file : ", ex.getMessage());
//        }
//        System.out.println("Text file string : " + textStr);
//
//        int[] arr = {5, 9, 11, 17, 4};
//        ArrayInterviewProg.subArraySum(arr, arr.length, 25);
//        ArrayInterviewProg.eficientSubArraySum(arr, arr.length, 25);
//
//        //creating LinkedList with 5 elements including head
//        LinkedList linkedList = new LinkedList();
//        LinkedList.Node head = linkedList.head();
//        linkedList.add(new LinkedList.Node("1"));
//        linkedList.add(new LinkedList.Node("2"));
//        linkedList.add(new LinkedList.Node("3"));
//        linkedList.add(new LinkedList.Node("4"));
//        linkedList.add(new LinkedList.Node("5"));
//        linkedList.add(new LinkedList.Node("6"));
//        linkedList.add(new LinkedList.Node("7"));
//
//        //finding middle element of LinkedList in single pass
//        LinkedList.Node current = head;
//        int length = 0;
//        LinkedList.Node middle = head;
//
//        while (current.next() != null) {
//            length++;
//            if (length % 2 == 0) {
//                middle = middle.next();
//            }
//            current = current.next();
//        }
//
//        if (length % 2 == 1) {
//            middle = middle.next();
//        }
//
//        System.out.println("length of LinkedList: " + length);
//        System.out.println("middle element of LinkedList : " + middle);
//
//        final StringBuilder str = new StringBuilder("String");
//        System.out.println("Final StringBuilder before concat : " + str);
//
//        str.append(" Builder");
//        System.out.println("Final StringBuilder after concat : " + str);
//
        testFinallyBlock(0);

    }

    public static double testFinallyBlock(int div) {
        try {
            System.out.println("This is try");
            return 10 / div;
        } catch (ArithmeticException e) {
            System.out.println("catch exception : " + e.getMessage());
            return 0;
        } finally {
            System.out.println("This is finally");
        }
    }

}

class LinkedList {

    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = new Node("head");
        tail = head;
    }

    public Node head() {
        return head;
    }

    public void add(Node node) {
        tail.next = node;
        tail = node;
    }

    public static class Node {

        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public String data() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String toString() {
            return this.data;
        }
    }

}

class A {

    public void eat() {
        System.out.println("A is eating");
    }

    public void sleep() {
        System.out.println("A is sleeping");
    }
}

class B extends A {

    public void fly() {
        System.out.println("B is flying");
    }
}

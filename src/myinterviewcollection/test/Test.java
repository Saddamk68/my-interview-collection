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
//        b.fly();   // runtime error upcasting is not allowed
//        A a = (B) new B();
//        a.fly();   // wont work
//        a.eat();   // work
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
        
        PrintNumber p = n -> System.out.println("square is: " + Math.sqrt(n));
        p.print(25);

        String textStr = "";
        try {
            FileReader fileReader = new FileReader("E:\\jsonFile.txt");
            int r;
            try {
                while ((r = fileReader.read()) != -1) {
                    textStr += (char) r;
                }
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger("Error while executing while loop : ", ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger("Error occure while reading a file : ", ex.getMessage());
        }
        System.out.println("Text file string : " + textStr);
        
        System.out.println("Executing testFinallyBlock method : " + testFinallyBlock(0));

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

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

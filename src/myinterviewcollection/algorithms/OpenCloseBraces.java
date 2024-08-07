/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.algorithms;

import java.util.Stack;

/**
 *
 * @author saddam
 */
public class OpenCloseBraces {
    
    public static void main(String[] args) {
        String test1 = "{}()[]";
        String test2 = "{[()]}";
        String test3 = "{[(])}";
        String test4 = "[{]}";

        System.out.println("Test 1: " + braces(test1)); // Expected: true
        System.out.println("Test 2: " + braces(test2)); // Expected: true
        System.out.println("Test 3: " + braces(test3)); // Expected: false
        System.out.println("Test 4: " + braces(test4)); // Expected: false
    }

    public static boolean braces(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }

}

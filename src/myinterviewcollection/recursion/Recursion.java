/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.recursion;

/**
 *
 * @author saddam
 */
public class Recursion {
    
    public static void main(String[] args) {
        System.out.println(reverseTheString("saddam"));
        
        System.out.println("Factorial of 5 is : " + factorial(5));
    }
 
    public static String reverseTheString(String str) {
        if (str.isBlank()) return str;
        
        return reverseTheString(str.substring(1)) + str.charAt(0);
    }
    
    public static int factorial(int num) {
        if (num == 0) return 1;
        
        return num * factorial(--num);
    }
    
}

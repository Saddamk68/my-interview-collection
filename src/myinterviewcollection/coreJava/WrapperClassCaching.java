/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.coreJava;

/**
 *
 * @author saddam
 */
public class WrapperClassCaching {
    
    public static void main(String[] args) {

        /**
         * @company : Siemen
         * 
         * when creating multiple object using Integer.valueOf or directly assigning a same value 
         * to an Integer within the range of -128 to 127 the same object will be returned.
         */
        Integer i = Integer.valueOf("100");
        Integer j = Integer.valueOf("100");
        System.out.println("100 : " + (i == j)); // true
        
        Integer k = Integer.valueOf("128");
        Integer l = Integer.valueOf("128");
        System.out.println("128 : " + (k == l)); // false
        
        Integer m = Integer.valueOf("-129");
        Integer n = Integer.valueOf("-129");
        System.out.println("-129 : " + (m == n)); // false

        Integer p = 10;
        Integer q = 10;
        System.out.println("10 : " + (p == q)); // true
        
        Integer x = 128;
        Integer y = 128;
        System.out.println("128 : " + (x == y)); // false
        
        System.out.println("new : " + (new Integer(10) == new Integer(10))); // false
        
        System.out.println("Byte " + (Byte.valueOf("-128") == Byte.valueOf("-128"))); // true

    }
    
}

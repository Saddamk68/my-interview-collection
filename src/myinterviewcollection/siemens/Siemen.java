/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.siemens;

/**
 *
 * @author Saddam Khan
 */
public class Siemen {

    int intVal = 0;
    
    public static void main(String[] args) {

        /**
         * when creating multiple object using Integer.valueOf or directly assigning a same value 
         * to an Integer within the range of -128 to 127 the same object will be returned.
         */
        Integer i = Integer.valueOf("100");
        Integer j = Integer.valueOf("100");
        System.out.println(i == j); // true
        
        Integer k = Integer.valueOf("128");
        Integer l = Integer.valueOf("128");
        System.out.println(k == l); // false
        
        Integer m = Integer.valueOf("-129");
        Integer n = Integer.valueOf("-129");
        System.out.println(m == n); // false

        Integer p = 10;
        Integer q = 10;
        System.out.println(p == q); // true
        
        System.out.println(new Integer(10) == new Integer(10)); // false
        
        System.out.println("Byte " + (Byte.valueOf("-128") == Byte.valueOf("-128"))); // true

        
        Siemen se = new Siemen();
        System.out.println(se.toString() + " 0 : " + se.intVal);
        
        se.intVal = 1;
        System.out.println(se.toString() + " 1 : " + se.intVal);

        se.m1(se);
        System.out.println(se.toString() + " 5 : " + se.intVal);
        
        new Siemen().m3();
        
    }
    
    /**
     * When you pass an object as an argument to a method, you're passing a copy of the reference to the object, 
     * not the actual object itself. Any changes made to the object's state (fields) 
     * inside the method will affect the original object outside the method, 
     * but reassigning the reference inside the method won't affect the original reference outside the method.
     */
    private void m1(Siemen se) {
        /**
         * here we have passed the original se object
         * and then we modified it's value which mean 
         * we have changed the main method original se object value
         */
        se.intVal = 10;
        System.out.println(se.toString() + " 2 : " + se.intVal);
        
        /**
         * since we are creating a new object it will be created locally 
         * hence it belongs to only m1 method 
         * it won't affect the original se object of main method
         */
        se = new Siemen();
        System.out.println(se.toString() + " 3 : " + se.intVal);
        se.intVal = 100;
        System.out.println(se.toString() + " 4 : " + se.intVal);
    }
    
    private void m2() {
        throw new Error();
    }
    
    private void m3() {
        try {
            m2();
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");            
        } finally {            
            System.out.println("C");
        }
        System.out.println("D");
    }
    
}

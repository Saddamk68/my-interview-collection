/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.coreJava;


/**
 *
 * @author saddam
 */
public class ErrorAndException {
    
    public static void main(String[] args) {
        
        System.out.println("Passing 0 : " + test(0));
        System.out.println("Passing 1 : " + test(1));
        
        new ErrorAndException().m3();
        
    }
    
    /**
     * @company : Epam
     * 
     * the finally block will always execute so it will always return 2
     */
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

    private void m2() {
        throw new Error();
    }
    
    /**
     * @company : Siemen
     */
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.coreJava;

/**
 *
 * @author saddam
 */
public class RunTimePolymorphism {
    
    public static void main(String arg[]) {
        B b = new B();
        b.method(1, "Hi");
    }
}

class A1 {

    public void method(int num, String str) {
        System.out.println("This is A class");
    }

    public int method(String str, int num) {
        System.out.println("This is A class");
        return num;
    }

}

class B extends A1 {

    public void method(int num, String str) {
        System.out.println("This is B class");
    }

}

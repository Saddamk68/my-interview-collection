/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.coreJava;

/**
 *
 * @author saddam
 */
public class CompileTimePolymorphism {

    public static void main(String arg[]) {
        A a = new A();
        a.method("Hi", 1);
        a.method(1, "Hi");
    }
    
}

/**
 * The methods must have the same name but different parameter lists.
 * They can have a different return type, but the return type alone does not determine overloading.
 * The access modifiers can vary.
 */
class A {

    public void method(int num, String str) {
        System.out.println("num : " + num + " String : " + str);
    }

    protected int method(String str, int num) {
        System.out.println("String : " + str + " num : " + num);
        return num;
    }
	
}

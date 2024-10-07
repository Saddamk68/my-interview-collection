/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.coreJava;

/**
 *
 * @author saddam
 */
public class PassByValue {
    
    int intVal = 0;
    
    public static void main(String[] args) {

        int z = 0;
        PassByValue instance = new PassByValue();
        System.out.println(instance.toString() + " 0 : " + instance.intVal + " " + z);
        
        instance.intVal = 1;
        z = 1;
        System.out.println(instance.toString() + " 1 : " + instance.intVal + " " + z);

        instance.m1(instance, z);
        System.out.println(instance.toString() + " 5 : " + instance.intVal + " " + z);
        
        
        System.out.println("Hello World!");
        Employee emp = new Employee(1, "A");

        System.out.println("Object - Before: " + emp.id + ", " + emp.name);
        callMethod(emp);
        System.out.println("Object - After: " +  + emp.id + ", " + emp.name);
    }
    
    /**
     * @company : Siemen
     * 
     * When you pass an object as an argument to a method, you're passing a copy of the reference to the object, 
     * not the actual object itself. Any changes made to the object's state (fields) 
     * inside the method will affect the original object outside the method, 
     * but reassigning the reference inside the method won't affect the original reference outside the method.
     */
    private void m1(PassByValue passByValue, int z) {
        /**
         * here we have passed the original se object
         * and then we modified it's value which mean 
         * we have changed the main method original se object value
         */
        passByValue.intVal = 10;
        z = 10;
        System.out.println(passByValue.toString() + " 2 : " + passByValue.intVal + " " + z);
        
        /**
         * since we are creating a new object it will be created locally 
         * hence it belongs to only m1 method 
         * it won't affect the original se object of main method
         */
        passByValue = new PassByValue();
        System.out.println(passByValue.toString() + " 3 : " + passByValue.intVal);
        passByValue.intVal = 100;
        z = 100;
        System.out.println(passByValue.toString() + " 4 : " + passByValue.intVal + " " + z);
        
    }
    
    public static void callMethod(Employee e) {
        e.id = 2;
        e.name = "B";
        e = new Employee(3, "C");
    }
    
}

class Employee {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

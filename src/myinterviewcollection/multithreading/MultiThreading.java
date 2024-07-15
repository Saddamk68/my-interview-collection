/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.multithreading;

/**
 *
 * @author $ADDAM
 */
// Java program to control the Main Thread 
public class MultiThreading extends Thread {

    public static void main(String[] args) {
        
        // getting reference to Main thread 
        Thread t = Thread.currentThread();

        // getting name of Main thread 
        System.out.println("Current thread: " + t.getName());

        // changing the name of Main thread 
        t.setName("Geeks");
        System.out.println("After name change: " + t.getName());

        // getting priority of Main thread 
        System.out.println("Main thread priority: " + t.getPriority());

        // setting priority of Main thread to MAX(10) 
        t.setPriority(MAX_PRIORITY);

        System.out.println("Main thread new priority: " + t.getPriority());

        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread");
        }

        // Main thread creating a child thread 
        ChildThread ct = new ChildThread();

        // getting priority of child thread 
        // which will be inherited from Main thread 
        // as it is created by Main thread 
        System.out.println("Child thread priority: " + ct.getPriority());

        // setting priority of Main thread to MIN(1) 
        ct.setPriority(MIN_PRIORITY);

        System.out.println("Child thread new priority: " + ct.getPriority());

        // starting child thread 
        ct.start();
        
        int n = 8; // Number of threads 
        for (int i = 0; i < n; i++) {
            Thread object = new Thread(new MultithreadingDemo());
            object.start();
        }
        
    }
    
}

// Java code for thread creation by implementing 
class MultithreadingDemo implements Runnable {

    public void run() {
        try {
            // Displaying the thread that is running 
            System.out.println("Thread "
                    + Thread.currentThread().getId()
                    + " is running");

        } catch (Exception e) {
            // Throwing an exception 
            System.out.println("Exception is caught");
        }
    }
}

// Child Thread class 
class ChildThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child thread");
        }
    }
  
}

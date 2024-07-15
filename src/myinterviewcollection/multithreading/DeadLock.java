/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.multithreading;

/**
 *
 * @author saddam
 */
public class DeadLock {

    public static void main(String[] arg) {
        
        final String resource1 = "Resource-1";
        final String resource2 = "Resource-2";

        Thread th1 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1 is acquiring lock on resource 1");
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    // do nothing
                }

                synchronized (resource2) {
                    System.out.println("Thread 1 is acquiring lock on resource 2");
                }
            }
        };

        Thread th2 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2 is acquiring lock on resource 2");
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    // do nothing
                }

                synchronized (resource1) {
                    System.out.println("Thread 2 is acquiring lock on resource 1");
                }
            }
        };

        th1.start();
        th2.start();

//        try {
//            System.out.println("Entering into Deadlock");
//            Thread.currentThread().join();
//            // the following statement will never execute 
//            System.out.println("This statement will never execute");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}

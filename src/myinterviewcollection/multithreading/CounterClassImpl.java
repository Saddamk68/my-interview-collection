/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saddam
 */
public class CounterClassImpl {
    
    public static void main(String[] arg) {
        
        // print count using multiple threads
        Thread th1 = new Thread(() -> {
            for (int i=0; i<20; i++) {
//                CounterClass.syncIncrementAndGet("Thread 1 : ");
                synchronized (System.out) {
                    System.out.println("Thread 1 : " + CounterClass.incrementAndGet());
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MultiThreading.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Thread th2 = new Thread(() -> {
            for (int i=0; i<20; i++) {
//                CounterClass.syncIncrementAndGet("Thread 2 : ");
                synchronized (System.out) {
                    System.out.println("Thread 2 : " + CounterClass.incrementAndGet());
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MultiThreading.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        th1.start();
        th2.start();
        
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MultiThreading.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
}

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
 * print odd and even number using two threads in sequence
 */
public class PrintEvenOddNumber {

    public static void main(String[] args) {

        // print odd number
        Thread th1 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 != 0) {
                    print("Thread 1 : " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PrintEvenOddNumber.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        // print even number
        Thread th2 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) {
                    print("Thread 2 : " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PrintEvenOddNumber.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(PrintEvenOddNumber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void print(String msg) {
        synchronized (System.out) {
            System.out.println(msg);
        }
    }

}

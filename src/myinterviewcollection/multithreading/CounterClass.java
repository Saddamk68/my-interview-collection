/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author saddam
 */
public class CounterClass {
    
        public static AtomicInteger count = new AtomicInteger(0);
        
        public static int getCounter() {
            return count.get();
        }
        
        public static int incrementAndGet() {
            return count.incrementAndGet();
        }
        
        public static void syncIncrementAndGet(String message) {
            synchronized (System.out) {
                System.out.println(message + count.incrementAndGet());
            }
        }
        
        public static int decrementAndGet() {
            return count.decrementAndGet();
        }
        
}

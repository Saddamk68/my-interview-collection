/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Saddam Khan
 */
public class ExecutorServicesSample {
    
    public static void main(String... arg) {
        singleThreadExecutor();
        fixedThreadPool();
        scheduleThreadPool();
        cachedThreadPool();
    }
    
    public static void singleThreadExecutor() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        
        for (int i=0; i<10; i++) {
            es.submit(() -> {
               System.out.println("Single Thread Executor : " + Thread.currentThread().getName());
            });
        }
        es.shutdown();
    }
    
    public static void fixedThreadPool() {
        ExecutorService es = Executors.newFixedThreadPool(5);
        
        for (int i=0; i<10; i++) {
            es.submit(() -> {
               System.out.println("Fixed Thread Pool : " + Thread.currentThread().getName());
            });
        }
        es.shutdown();
    }
    
    public static void scheduleThreadPool() {
        ExecutorService es = Executors.newScheduledThreadPool(100);
        
        for (int i=0; i<10; i++) {
            es.submit(() -> {
               System.out.println("Schedule Thread Executor : " + Thread.currentThread().getName());
            });
        }
        es.shutdown();
    }
    
    public static void cachedThreadPool() {
        ExecutorService es = Executors.newCachedThreadPool();
        
        for (int i=0; i<10; i++) {
            es.submit(() -> {
               System.out.println("Cached Thread Pool : " + Thread.currentThread().getName());
            });
        }
        es.shutdown();
    }
    
}

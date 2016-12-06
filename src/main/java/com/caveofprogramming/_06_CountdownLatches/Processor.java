package com.caveofprogramming._06_CountdownLatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
    private CountDownLatch latch;
    
    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }
    
    public void run() {
        System.out.println("Started, countDown number: " + latch.getCount());
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        latch.countDown();
    }
}
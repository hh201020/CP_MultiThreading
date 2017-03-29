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
        
        try {
            Thread.sleep(1000);
            System.out.println("sub thread countDown number: " + latch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        latch.countDown();
    }
}
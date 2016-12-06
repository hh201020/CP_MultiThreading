package com.caveofprogramming._06_CountdownLatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        
        CountDownLatch latch = new CountDownLatch(3);
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
		for (int i = 0; i < 11; i++) {
			if (latch.getCount() > 0) {
		        System.out.println("main thread countDown : " + latch.getCount());

				executor.submit(new Processor(latch));
				latch.countDown();
			}
		}
        
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("All tasks submitted.");
        System.out.println("Completed.");
		executor.shutdown();

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		}
    }

}
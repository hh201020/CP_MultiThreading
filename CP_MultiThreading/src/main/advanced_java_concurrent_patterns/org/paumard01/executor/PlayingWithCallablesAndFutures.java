package org.paumard01.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PlayingWithCallablesAndFutures {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		Callable<String> task = () -> {
			throw new IllegalStateException("I throw an exception in thread " + Thread.currentThread().getName());
		};

		ExecutorService executor = Executors.newFixedThreadPool(4);
//		ExecutorService executor = Executors.newCachedThreadPool();
//		ExecutorService executor = Executors.newSingleThreadExecutor();
//		ExecutorService executor = Executors.newWorkStealingPool();
//		ExecutorService executor = Executors.newScheduledThreadPool(4);
//		ExecutorService executor = Executors.newSingleThreadScheduledExecutor();

		try {
			for (int i = 0; i < 10; i++) {
				Future<String> future = executor.submit(task);
				System.out.println("I get: " + future.get());
			}
		} finally {
			executor.shutdown();
//			executor.awaitTermination(3000, TimeUnit.DAYS);
//			executor.shutdownNow();
		}
	}
}

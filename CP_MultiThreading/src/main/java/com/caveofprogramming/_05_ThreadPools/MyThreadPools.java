package com.caveofprogramming._05_ThreadPools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadPools {
	
	class Runner implements Runnable {
		private int id;

		public Runner(int id) {
			this.id = id;
		}

		public void run() {
			System.out.println("Starting: " + id);
			process();
			System.out.println("Completed: " + id);
		}
	}
	
	private Random random = new Random();

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	public void stageOne() {

		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			list1.add(random.nextInt(100));
		}

	}

	public void stageTwo() {

		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			list2.add(random.nextInt(100));
		}

	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}
	public void main() {
		System.out.println("Starting ...");

		long start = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 9; i++) {
			executor.submit(new Runner(i));
		}

		executor.shutdown();

		System.out.println("All tasks submitted.");

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		}

		System.out.println("All tasks completed.");
		
		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start));
		System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
	}
}
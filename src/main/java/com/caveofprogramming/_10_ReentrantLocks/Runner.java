package com.caveofprogramming._10_ReentrantLocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	private void increment(String workingThread) {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
		System.out.println("in the thread: " + workingThread);
	}

	public void firstThread() throws InterruptedException {
		lock.lock();

		System.out.println("Waiting ....");
		cond.await();

		System.out.println("Woken up!");

		try {
			increment("First Thread");
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() throws InterruptedException {

		Thread.sleep(1000);
		lock.lock();

		System.out.println("Press the return key!");
		new Scanner(System.in).nextLine();
		System.out.println("Got return key!");

		cond.signal();

		try {
			increment("Second Thread");
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}
}
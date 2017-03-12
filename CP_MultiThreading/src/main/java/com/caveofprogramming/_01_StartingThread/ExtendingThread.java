package com.caveofprogramming._01_StartingThread;

class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello: " + i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ExtendingThread {

	public static void main(String[] args) {
		MyThread runner1 = new MyThread();
		runner1.start();

		MyThread runner2 = new MyThread();
		runner2.start();

	}
}
package com.caveofprogramming._01_StartingThread;

public class AnonymousThreads {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {

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
		});

		thread1.start();
	}
}
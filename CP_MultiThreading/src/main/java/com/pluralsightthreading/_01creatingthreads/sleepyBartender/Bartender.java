package com.pluralsightthreading._01creatingthreads.sleepyBartender;

import java.util.concurrent.TimeUnit;

public class Bartender implements Runnable
{
	public void run()
	{
		System.out.println("Bartender: My boss isn't in today; time for a quick snooze!");
		
		while (true) {
			if (Thread.interrupted()) {
				System.out.println("Bartender: Zzz er erm, is someone waiting?");
			}
			
			try
			{
				TimeUnit.SECONDS.sleep(15);
			}
			catch (InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}
		}
	}
}

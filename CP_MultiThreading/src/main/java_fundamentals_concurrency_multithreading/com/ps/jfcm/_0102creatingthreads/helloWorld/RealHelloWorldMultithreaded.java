package com.ps.jfcm._0102creatingthreads.helloWorld;

public class RealHelloWorldMultithreaded
{
	public static class Greeter extends Thread
	{
		private String country;
		
		public Greeter(String country)
		{
			super(country + " thread"); // call the thread constructor to name the thread
			this.country = country;
		}

		public void run()
		{
			long id = Thread.currentThread().getId();
			
			System.out.println(id + ": Hello " + country + "!");
		}
	}

	public static void main(String[] args)
	{
		String countries[] = { "France", "India", "China", "USA", "Germany" };

		for (String country : countries)
		{
			new Greeter(country).start();
		}
	}
}

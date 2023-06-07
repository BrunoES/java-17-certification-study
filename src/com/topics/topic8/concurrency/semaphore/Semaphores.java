package com.topics.topic8.concurrency.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semaphores {

	static Semaphore semaphore = new Semaphore(1);
	
	public static void main(String[] args) {
		System.out.println("Available permit : " + semaphore.availablePermits());
		System.out.println("Number of threads waiting to acquire: " + semaphore.getQueueLength());

		ExecutorService executor = Executors.newFixedThreadPool(10);
		Runnable r1 = () -> {
			if (semaphore.tryAcquire()) {
		        try {
		        	try {
						Thread.sleep(5000); // demora 5 segundos pra executar.
						System.out.println("r1 Executed");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        }
		        finally {
		            semaphore.release();
		        }
		    }
		};
		
		// Executor Service n�o trava a execu��o aqui na thread local.
		
		executor.execute(r1);
		// executor.execute(r1); //  Se chamar um Executor normal tamb�m travar� a execu��o aqui
		// r1.run(); Se chamar assim, travar� a execu��o aqui
		
		Runnable r2 = () -> {
			try {
				if (semaphore.tryAcquire(6000, TimeUnit.MILLISECONDS)) { // tryAcquire com 6 Segundos de timeout
				    try {
				    	System.out.println("r2 Executed");
				    }
				    finally {
				        semaphore.release();
				    }
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		r2.run();
		
		System.out.println("Available permit : " + semaphore.availablePermits());
		System.out.println("Number of threads waiting to acquire: " + semaphore.getQueueLength());
	}

}

package com.topics.topic8.concurrency.threads;

public class Notify1 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this) {
			System.out.println("Starting of " + Thread.currentThread());
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " notified");
		}
	}

}

package com.topics.topic8.concurrency.threads;

public class Notify3 extends Thread {

	private Notify1 notify = null;
	
	public Notify3(Notify1 notify) {
		this.notify = notify;
	}
	
	@Override
	public void run() {
		synchronized(this.notify) {
			System.out.println("Starting of " + Thread.currentThread());
			
			this.notify.notifyAll();
			
			System.out.println(Thread.currentThread().getName() + " notified");
		}
	}
}

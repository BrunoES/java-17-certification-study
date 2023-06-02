package com.topics.topic8.concurrency.threads;

public class Notify2 extends Thread {

	private Notify1 notify = null;
	
	public Notify2(Notify1 notify) {
		this.notify = notify;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this.notify) {
			System.out.println("Starting of " + Thread.currentThread());
			
			try {
				this.notify.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + " notified");
		}
	}

}

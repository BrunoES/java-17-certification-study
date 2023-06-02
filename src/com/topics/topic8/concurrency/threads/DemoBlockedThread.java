package com.topics.topic8.concurrency.threads;

public class DemoBlockedThread implements Runnable {

	@Override
	public void run() {
		method();
	}

	public static synchronized void method() {
		while(true) {
			// System.out.println("Executing lock");
		}
	}
}

package com.topics.topic8.concurrency.threads.threadsafe;

public class SynchronizedExamples {
	int i = 0;
	
	public synchronized void incrementCounter1() {
		i = i++;
	}
	
	public void incrementCounter2() {
		synchronized(this) {
			i = i++;
		}
	}
}

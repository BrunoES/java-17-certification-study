package com.topics.topic8.concurrency.threads.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicObjectsExample {
	
	private final AtomicInteger counter = new AtomicInteger();
	
	public void incrementCounter() {
		// Se aqui fosse um counter++ ou algo assim, não seria threadsafe.
		counter.incrementAndGet();
	}
	
	public int getCounter() {
		return counter.get();
	}
	
}

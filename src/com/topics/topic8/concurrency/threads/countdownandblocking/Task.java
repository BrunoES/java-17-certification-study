package com.topics.topic8.concurrency.threads.countdownandblocking;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable {
	
	private CyclicBarrier barrier;

	public Task(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
            System.out.println(Thread.currentThread().getName() + " is waiting");
            Thread.sleep(2000);
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " is released");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
	}
	
}

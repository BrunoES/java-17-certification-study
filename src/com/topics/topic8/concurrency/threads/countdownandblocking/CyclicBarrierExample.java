package com.topics.topic8.concurrency.threads.countdownandblocking;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(5, () -> {
			System.out.println("Todas tarefas completadas");
		});
		
		Thread t1 = new Thread(new Task(barrier), "T1");
		Thread t2 = new Thread(new Task(barrier), "T2");
		Thread t3 = new Thread(new Task(barrier), "T3");
		Thread t4 = new Thread(new Task(barrier), "T4");
		Thread t5 = new Thread(new Task(barrier), "T5");
		
		if(!barrier.isBroken()) {
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();
		}
	}
	
}

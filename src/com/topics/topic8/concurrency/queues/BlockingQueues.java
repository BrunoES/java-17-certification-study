package com.topics.topic8.concurrency.queues;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/*
 * https://www.baeldung.com/java-blocking-queue
 */
public class BlockingQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		unboundedQueue();
		boundedQueue();
		add();
		put();
		offer();
		take();
		pool();
	}
	
	public static void unboundedQueue() {
		System.out.println("\n unboundedQueue");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
		System.out.println("Size � o Integer.MAX_VALUE, mas come�a com 0 " + blockingQueue.size());
	}
	
	
	public static void boundedQueue() {
		System.out.println("\n boundedQueue");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(10);
		System.out.println("Size �: " + 10);
	}
	
	public static void add() {
		System.out.println("\n add");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
		boolean inseriu = blockingQueue.add("A");
		System.out.println("Retorna um boolean: " + inseriu + ", se n�o consegue, lan�a uma IllegalStateException.");
	}
	
	public static void put() {
		System.out.println("\n put");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(1);
		try {
			
			// Thread ir� consumir a fila ap�s 2 seg.
			Runnable r = () -> {
				try {
					Thread.sleep(2000);
					blockingQueue.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
			
			blockingQueue.put("A");
			r.run();
			
			// Fica aguardando liberar espa�o, se n�o, n�o libera a thread.
			blockingQueue.put("B");
			
			
			System.out.println("Insere o elemento na fila, esperando por um espa�o livre");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void offer() {
		System.out.println("\n offer");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(1);
		
		boolean inseriu = blockingQueue.offer("A");
		try {
			// Espera por 5 segundos para tentar inserir, se n�o conseguir, aborta.
			boolean inseriuComTimeOut = blockingQueue.offer("A", 5000L, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void take() {
		System.out.println("\n take");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
	}
	
	public static void poll() {
		System.out.println("\n poll");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
	}

}

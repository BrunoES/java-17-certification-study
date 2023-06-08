package com.topics.topic8.concurrency.queues;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/*
 * https://www.baeldung.com/java-blocking-queue
 * Multithread example in this link above.
 */
public class BlockingQueues {

	private static ExecutorService executor = Executors.newFixedThreadPool(10);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		unboundedQueue();
		boundedQueue();
		add();
		put();
		offer();
		take();
		poll();
	}
	
	public static void unboundedQueue() {
		System.out.println("\n unboundedQueue");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
		System.out.println("Size é o Integer.MAX_VALUE, mas começa com 0 " + blockingQueue.size());
	}
	
	
	public static void boundedQueue() {
		System.out.println("\n boundedQueue");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(10);
		System.out.println("Size é: " + 10);
	}
	
	public static void add() {
		System.out.println("\n add");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
		boolean inseriu = blockingQueue.add("A");
		System.out.println("Retorna um boolean: " + inseriu + ", se não consegue, lança uma IllegalStateException.");
	}
	
	public static void put() {
		System.out.println("\n put");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(1);
		try {
			
			// Thread irá consumir a fila após 2 seg.
			Runnable r = () -> {
				try {
					Thread.sleep(2000);
					blockingQueue.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
			executor.execute(r);
			
			blockingQueue.put("A");
			
			// Fica aguardando liberar espaço, se não, não libera a thread.
			blockingQueue.put("B");
			
			
			System.out.println("Insere o elemento na fila, esperando por um espaço livre");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void offer() {
		System.out.println("\n offer");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(1);
		
		boolean inseriu = blockingQueue.offer("A");
		try {
			// Espera por 5 segundos para tentar inserir, se não conseguir, aborta.
			boolean inseriuComTimeOut = blockingQueue.offer("A", 5000L, TimeUnit.MILLISECONDS);
			System.out.println("Inseriu offer com timeour?: " + inseriuComTimeOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void take() {
		System.out.println("\n take");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
		
		// Thread irá alimentar a fila após 2 seg.
		Runnable r = () -> {
			try {
				Thread.sleep(2000);
				blockingQueue.add("A");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		executor.execute(r);
		
		try {
			// Fica aguardando um registro disponível,se não, não libera a thread, neste caso, consome após 2 segundos.
			String a = blockingQueue.take();
			System.out.println("Recuperou: " + a);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void poll() {
		System.out.println("\n poll");
		
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
		
		// Thread irá alimentar a fila após 2 seg.
		Runnable r = () -> {
			try {
				Thread.sleep(2000);
				blockingQueue.add("A");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		executor.execute(r);
		
		try {
			// Espera 1 segundo por um registro disponível, se não retorna null;
			String a = blockingQueue.poll(1000, TimeUnit.MILLISECONDS);
			System.out.println("Recuperou: " + a);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

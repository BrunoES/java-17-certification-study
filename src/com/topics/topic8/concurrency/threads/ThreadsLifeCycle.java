package com.topics.topic8.concurrency.threads;

/*
 * States of a thread:
 * NEW – a newly created thread that has not yet started the execution
 * RUNNABLE – either running or ready for execution but it's waiting for resource allocation
 * BLOCKED – waiting to acquire a monitor lock to enter or re-enter a synchronized block/method
 * WAITING – waiting for some other thread to perform a particular action without any time limit
 * TIMED_WAITING – waiting for some other thread to perform a specific action for a specified period
 * TERMINATED – has completed its execution
 */
public class ThreadsLifeCycle {

	public static void main(String[] args) throws InterruptedException {
		newAndRunning();
		Thread.sleep(1000);
		blocked();
		Thread.sleep(1000);
		waiting();
		Thread.sleep(1000);
		timedWaiting();
		Thread.sleep(1000);
		waitAndNotifyAll();
	}
	
	public static void newAndRunning() {
		System.out.println("\n newAndRunning");
		
		Runnable r = () -> System.out.println("Thread executing");
		Thread t = new Thread(r);
		System.out.println(t.getState());
		t.start();
		System.out.println(t.getState());
	}
	
	public static void blocked() throws InterruptedException {
		System.out.println("\n blocked");
		
		Thread t1 = new Thread(new DemoBlockedThread());
		Thread t2 = new Thread(new DemoBlockedThread());
		
		t1.start();
		t2.start();
		
		Thread.sleep(1000);
        
        System.out.println(t2.getState());
	}
	
	public static void waiting() throws InterruptedException {
		System.out.println("\n waiting");
		
		// Join method in Java allows one thread to wait until another thread completes its execution. In simpler words, it means it waits for the other thread to die
		WaitingState.testar();
	}
	
	public static void timedWaiting() throws InterruptedException {
		System.out.println("\n timedWaiting");
		
		DemoWaitingStateRunnable w = new DemoWaitingStateRunnable();
		Thread t = new Thread(w);
		t.start();
		
		Thread.sleep(1000);
		
		System.out.println(t.getState());
	}
	
	public static void waitAndNotifyAll() throws InterruptedException {
		Notify1 notify1 = new Notify1();
		Notify2 notify2 = new Notify2(notify1);
		Notify3 notify3 = new Notify3(notify1);
		
		Thread t1 = new Thread(notify1, "Thread 1");
		Thread t2 = new Thread(notify2, "Thread 2");
		Thread t3 = new Thread(notify3, "Thread 3");
		
		// Quando no notifyAll é chamado, todas as ocorrêncas de notify1 aguardando são liberadas.
		t1.start();
		t2.start();
		Thread.sleep(1000);
		t3.start();
	}
	
}

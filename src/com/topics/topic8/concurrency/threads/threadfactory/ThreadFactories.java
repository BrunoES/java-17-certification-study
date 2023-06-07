package com.topics.topic8.concurrency.threads.threadfactory;

import java.util.concurrent.TimeUnit;

/*
 * https://www.tutorialspoint.com/difference-between-thread-and-runnable-in-java
 * https://www.baeldung.com/java-util-concurrent
 */
public class ThreadFactories {

	public static void main(String[] args) {
		
		Runnable runnableTask = () -> {
		    try {
		        TimeUnit.MILLISECONDS.sleep(300);
		        System.out.println(Thread.currentThread().getName());
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		};
		
		Thread thread1 = new Thread(runnableTask);
		
		// ou
		
		ThreadFactoryExample tf = new ThreadFactoryExample();
		Thread thread2 = tf.newThread(runnableTask);
		
		thread1.start();
		thread2.start();
	}

}

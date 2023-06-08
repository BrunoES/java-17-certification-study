package com.topics.topic8.concurrency.queues;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * https://www.baeldung.com/java-delay-queue
 */
public class DelayQueues {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
	    
	    BlockingQueue<DelayObject> queue = new DelayQueue<>();
	    int numberOfElementsToProduce = 11;
	    int delayOfEachProducedMessageMilliseconds = 500;
	    DelayQueueConsumer consumer = new DelayQueueConsumer(queue, numberOfElementsToProduce);
	    DelayQueueProducer producer = new DelayQueueProducer(queue, numberOfElementsToProduce, delayOfEachProducedMessageMilliseconds);

	    executor.submit(producer);
	    executor.submit(consumer);

	    executor.awaitTermination(5, TimeUnit.SECONDS);
	    executor.shutdown();
	    
	    // Enquanto fila ainda possui elementos valida se ela 
	    while(!queue.isEmpty()) {
	    	Thread.sleep(500);
	    	if(queue.isEmpty()) {
		    	System.out.println("Número de elementos produzidos: " + numberOfElementsToProduce);
			    System.out.println("Número de elementos consumidos: " + consumer.numberOfConsumedElements.get());
	    	}
	    }
	}

}

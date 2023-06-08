package com.topics.topic8.concurrency.queues;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class DelayQueueConsumer implements Runnable {
    private BlockingQueue<DelayObject> queue;
    private Integer numberOfElementsToTake;
    public AtomicInteger numberOfConsumedElements = new AtomicInteger();

    // standard constructors

    public DelayQueueConsumer(BlockingQueue<DelayObject> queue, int numberOfElementsToTake) {
		this.queue = queue;
		this.numberOfElementsToTake = numberOfElementsToTake;
	}

	@Override
    public void run() {
        for (int i = 0; i < numberOfElementsToTake; i++) {
            try {
                DelayObject object = queue.take();
                numberOfConsumedElements.incrementAndGet();
                System.out.println("Objeto consumido: " + object);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
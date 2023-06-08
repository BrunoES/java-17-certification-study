package com.topics.topic8.concurrency.queues;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class DelayQueueProducer implements Runnable {
	 
    private BlockingQueue<DelayObject> queue;
    private Integer numberOfElementsToProduce;
    private Integer delayOfEachProducedMessageMilliseconds;

    // standard constructor

    public DelayQueueProducer(BlockingQueue<DelayObject> queue, int numberOfElementsToProduce, int delayOfEachProducedMessageMilliseconds) {
		this.queue = queue;
		this.numberOfElementsToProduce = numberOfElementsToProduce;
		this.delayOfEachProducedMessageMilliseconds = delayOfEachProducedMessageMilliseconds;
	}

	@Override
    public void run() {
        for (int i = 0; i < numberOfElementsToProduce; i++) {
            DelayObject object
              = new DelayObject(
                UUID.randomUUID().toString(), delayOfEachProducedMessageMilliseconds);
            try {
                queue.put(object);
                System.out.println("Objeto produzido: " + object);
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
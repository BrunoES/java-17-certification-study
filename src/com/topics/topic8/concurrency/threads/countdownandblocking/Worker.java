package com.topics.topic8.concurrency.threads.countdownandblocking;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

	private List<String> outputScraper;
    private CountDownLatch countDownLatch;

    public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
        	System.out.println("Fazendo alguma coisa");
			Thread.sleep(1000);
			System.out.println("Terminei alguma coisa");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        outputScraper.add("Counted down");
        countDownLatch.countDown();
    }
}

package com.topics.topic8.concurrency.threads.countdownandblocking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * https://www.baeldung.com/java-countdown-latch
 * Example with ThreadPoll in this link above.
 */
public class CountDownLatchExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
		CountDownLatch countDownLatch = new CountDownLatch(11);
		
		List<Thread> workers = Stream.generate(
				() -> new Thread(new Worker(outputScraper, countDownLatch)))
				.limit(11)
				.collect(Collectors.toList());
		
		workers.forEach(Thread::start);
		
		countDownLatch.await();
		
		// Caso dê algum erro em alguma Thread, e o counter nunca chegue a 0,
		// é possível definir um timeout para o CountDownLatch:
		countDownLatch.await(5000, TimeUnit.MILLISECONDS); 
		
		System.out.println("CountDownLatch final: " + countDownLatch.getCount());
	}
}

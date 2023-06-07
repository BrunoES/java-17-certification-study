package com.topics.topic8.concurrency.threads.threadsafe;

import java.util.Arrays;
import java.util.List;

public class ThreadB extends Thread {
	
	private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    
    @Override
    public void run() {
        numbers.forEach(System.out::println);
    }

}

package com.topics.topic8.concurrency.threads.threadfactory;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample implements ThreadFactory {
	
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, "Thread Feita pelo Factory");
        return t;
	}

}

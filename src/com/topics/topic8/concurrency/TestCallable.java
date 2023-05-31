package com.topics.topic8.concurrency;

import java.util.UUID;
import java.util.concurrent.Callable;

public class TestCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		return UUID.randomUUID().toString();
	}

}

package com.topics.topic8.concurrency;

import java.util.concurrent.Executor;

public class InvokerExecutor implements Executor {

	@Override
	public void execute(Runnable command) {
		command.run();
	}

}

package com.topics.topic8.concurrency.queues;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayObject implements Delayed {
	private String data;
	private long startTime;

	public DelayObject(String data, long delayInMilliseconds) {
        this.data = data;
        // Tempo de delay de consumo, ou seja, a partir de quanto tempo inserido, o objeto
        // estará disponível para consumo.
        this.startTime = System.currentTimeMillis() + delayInMilliseconds;
    }
	
	@Override
	public int compareTo(Delayed o) {
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
	    long diff = startTime - System.currentTimeMillis();
	    return unit.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public long getStartTime() {
		return this.startTime;
	}

}

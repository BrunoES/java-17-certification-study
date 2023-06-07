package com.topics.topic8.concurrency.threads.threadsafe;

public class StateHolder {
	private final String state;

	public StateHolder(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
}

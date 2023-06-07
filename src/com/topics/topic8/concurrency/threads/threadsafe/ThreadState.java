package com.topics.topic8.concurrency.threads.threadsafe;

public class ThreadState {

	public static final ThreadLocal<StateHolder> statePerThread = new ThreadLocal<StateHolder>() {
	    @Override
	    protected StateHolder initialValue() {
            return new StateHolder("active");  
        }
    };

    public static StateHolder getState() {
        return statePerThread.get();
    }
	
}

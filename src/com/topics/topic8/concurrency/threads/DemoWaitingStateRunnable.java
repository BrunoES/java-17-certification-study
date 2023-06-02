package com.topics.topic8.concurrency.threads;

public class DemoWaitingStateRunnable implements Runnable {
	
	public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        
        System.out.println(WaitingState.t1.getState());
    }
	
}

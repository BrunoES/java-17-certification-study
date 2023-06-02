package com.topics.topic8.concurrency.threads;

public class WaitingState implements Runnable {
    public static Thread t1;

    public static void testar() {
    	t1 = new Thread(new WaitingState());
        t1.start();
    }
    
    public void run() {
        Thread t2 = new Thread(new DemoWaitingStateRunnable());
        t2.start();

        try {
        	// Ao chamar join de t2 dentro de t1, t1 ficará aguardando t2 terminar para 'morrer';
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
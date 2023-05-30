package com.topics.topic8.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * https://www.baeldung.com/java-concurrent-locks
 */
public class LockMechanisms {

	public static void main(String[] args) {
		lock();
		lockInterruptibly();
		tryLock();
		unlock();
	}
	
	public static void lock() {
		System.out.println("\n lock");
		
		Lock lock = new ReentrantLock();
		lock.lock();
	}
	
	public static void lockInterruptibly() {
		System.out.println("\n lockInterruptibly");
		
	}
	
	public static void tryLock() {
		System.out.println("\n tryLock");
		
	}
	
	public static void unlock() {
		System.out.println("\n unlock");
		
	}

}

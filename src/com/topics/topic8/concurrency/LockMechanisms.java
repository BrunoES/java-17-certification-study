package com.topics.topic8.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/*
 * https://www.baeldung.com/java-concurrent-locks
 * A synchronizedblock is fully contained within a method. We can have Lock APIs lock() and unlock() operation in separate methods.
 * A synchronized block doesn't support the fairness. Any thread can acquire the lock once released, and no preference can be specified. We can achieve fairness within the Lock APIs by specifying the fairness property. It makes sure that the longest waiting thread is given access to the lock.
 * A thread gets blocked if it can't get an access to the synchronized block. The Lock API provides tryLock() method. The thread acquires lock only if it's available and not held by any other thread. This reduces blocking time of thread waiting for the lock.
 * A thread that is in “waiting” state to acquire the access to synchronized block can't be interrupted. The Lock API provides a method lockInterruptibly() that can be used to interrupt the thread when it's waiting for the lock.
 */
public class LockMechanisms {

	public static void main(String[] args) {
		lock();
		lockInterruptibly();
		tryLock();
		unlock();
		
		// ReadWriteLock: Provê locks de leitura e escrita.
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		readWriteLock.readLock(); // returns the lock that's used for reading.
		readWriteLock.writeLock(); // returns the lock that's used for writing.
		
		Lock readLock = readWriteLock.readLock();
		readLock.lock();
		readLock.unlock();
		
		Lock writeLock = readWriteLock.writeLock();
		writeLock.lock();
		writeLock.unlock();
		
		// StampedLock: Chega se o lock continua válido antes de prosseguir.
		StampedLock stampedLock = new StampedLock();
		stampedLock.readLock(); // returns the lock that's used for reading.
		readWriteLock.writeLock(); // returns the lock that's used for writing.
		
		long read = stampedLock.readLock();
		stampedLock.unlock(read);
		stampedLock.unlockRead(read);
		
		long write1 = stampedLock.writeLock();
		stampedLock.unlock(write1);
		long write2 = stampedLock.writeLock();
		stampedLock.unlockWrite(write2);
		
		// Não precisa validar se write está locando, pois é apneas leitura
		long otimistaRead = stampedLock.tryOptimisticRead();
		
	}
	
	/*
	 * Acquire the lock if it's available. If the lock isn't available, a thread gets blocket until the lock is released.
	 */
	public static void lock() {
		System.out.println("\n lock");
		
		Lock lock = new ReentrantLock();
		lock.lock();
		
	}
	
	/*
	 * This is similar to the lock(), but it allows the blocked thread to be interrupted and resume the execution through a thrown java.lang.InterruptedException.
	 */
	public static void lockInterruptibly() {
		System.out.println("\n lockInterruptibly");
		
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			lock.lockInterruptibly();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * tryLock: This is a nonblocking version of lock() method. It attempts to acquire the lock immediately, return true if locking succeeds.
	 * tryLock(long timeout, TimeUnit timeUnit): This is similar to tryLock(), except it waits up the given timeout before giving up trying to acquire the Lock.
	 */
	public static void tryLock() {
		System.out.println("\n tryLock");
		
		Lock lock = new ReentrantLock();
		lock.lock();
		lock.tryLock();
		try {
			lock.tryLock(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * unlocks the Lock instance. release thread.
	 */
	public static void unlock() {
		System.out.println("\n unlock");
		
System.out.println("\n lock");
		
		Lock lock = new ReentrantLock();
		lock.lock();
		
		lock.unlock();
	}

}

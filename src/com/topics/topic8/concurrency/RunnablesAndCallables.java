package com.topics.topic8.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Runnables não retornam valor.
 * The Runnable interface is a functional interface and has a single run() method that doesn't accept any parameters or return any values.
 * 
 * Callables retornam valor
 * https://www.baeldung.com/java-runnable-callable
 */
public class RunnablesAndCallables {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Ambas são interfaces funcionais, portanto podem ser declaradas como lambdas.
		
		// Runnable:
		/*
		 
		 public interface Runnable {
		    public void run();
		}
		 
		 */
		Runnable thread = new TestRunnable();
		thread.run();
		
		// ou:
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		executor.submit(thread);
		
		
		// Callabe:
		/*
		 
		 public interface Callable<V> {
		    V call() throws Exception;
		}
		 
		 */
		Callable callable = new TestCallable();
		Future result = executor.submit(callable);
		System.out.println(result.get());
		
		
		
		// EXCEPTIONS:
		
		// With Runnable
		// Since the method signature does not have the “throws” clause specified, we don't have a way to propagate further checked exceptions.
		
		// With Callable
		// Callable‘s call() method contains the “throws Exception” clause, so we can easily propagate checked exceptions further:
		
		Future result2 = executor.submit(callable);
		System.out.println(result2.get());
		// .get Lançará uma ExecutionException, que no getCause, terá a exception original lançada pelo método do Callable.
	}

}

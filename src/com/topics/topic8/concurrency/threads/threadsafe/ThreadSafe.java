package com.topics.topic8.concurrency.threads.threadsafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafe {

	public static void main(String[] args) {
		
		// Metodo Thread Safe
		System.out.println(exemploDeMetodoThreadSafe(1));
		
		// Classe Immtable:
		ImmutableClassExample immutableClass = new ImmutableClassExample("Teste");
		
		// Thread with ThreadLocal Attribute
		ThreadA a = new ThreadA();
		ThreadA b = new ThreadA();
		a.start();
		b.start();
		
		// ThreadLocal by Thread
		// Armazena a informa��o apenas na thread atual;
		// Cada thread pode ter seu(s) atributo(s) ThreadLocal(s);
		ThreadState ts = new ThreadState();
		System.out.println(ts.getState().getState());
		
		
		// Synchronized collections
		Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
		Thread thread1 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
		Thread thread2 = new Thread(() -> syncCollection.addAll(Arrays.asList(7, 8, 9, 10, 11, 12)));
		// Os m�todos das synchronized collections possuem locks, cada chamada � lockada.
		thread1.start();
		thread2.start();
		
		
		// Concurrent Collections
		/*
		 * Unlike their synchronized counterparts, concurrent collections achieve thread-safety by dividing their data into segments. In a ConcurrentHashMap, for example, several threads can acquire locks on different map segments, so multiple threads can access the Map at the same time.
		 * Concurrent collections are much more performant than synchronized collections, due to the inherent advantages of concurrent thread access.
		 */
		// V�rias threads podem acessar uma concurrent collection, n�o h� lock nos m�todos, por�m o conte�do da collection � dividido em seguimentos.
		Map<String, String> concurrentMap = new ConcurrentHashMap<>();
		concurrentMap.put("1", "one");
		concurrentMap.put("2", "two");
		concurrentMap.put("3", "three");
		
		
		/// Atomic objects:
		AtomicObjectsExample atomicIntegerExample = new AtomicObjectsExample();
		int x = atomicIntegerExample.getCounter();
		System.out.println(x);
		
		
		// Objects as lock:
		// Evitar usar Strings ou objetos "cache�veis" como lock, pois pode ocorrer do lock apontar para a mesma refer�ncia em 2 locks diferentes.
		// Usa o objeto como lock, quando o mesmo � par�metro no sincronized.
		class ObjectLockCounter {

		    private int counter = 0;
		    private final Object lock = new Object();
		    
		    public void incrementCounter() {
		        synchronized(lock) {
		            counter += 1;
		        }
		    }
		}
	}
	
	// Calcula fatorial
	/*
	 * Pode ser chamado N vezes por N threads ao mesmo tempo que seu resultado n�o ser� afetado.
	 * A estrat�gias stateless � a melhor forma de se chegar ao ThreadSafe.
	 */
	public static BigInteger exemploDeMetodoThreadSafe(int number) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= number; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }

}

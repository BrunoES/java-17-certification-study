package com.topics.topic8.concurrency.threads.threadsafe;

import java.math.BigInteger;

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
		// Armazena a informação apenas na thread atual;
		// Cada thread pode ter seu(s) atributo(s) ThreadLocal(s);
		ThreadState ts = new ThreadState();
		System.out.println(ts.getState().getState());
	}
	
	// Calcula fatorial
	/*
	 * Pode ser chamado N vezes por N threads ao mesmo tempo que seu resultado não será afetado.
	 * A estratégias stateless é a melhor forma de se chegar ao ThreadSafe.
	 */
	public static BigInteger exemploDeMetodoThreadSafe(int number) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= number; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }

}

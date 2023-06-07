package com.topics.topic8.concurrency.threads.threadsafe;

/*
 * Classe com todos atributos final
 * Sem setter
 */
public class ImmutableClassExample {
	
	private final String name;
	
	public ImmutableClassExample(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

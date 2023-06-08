package com.topics.topic8.concurrency.threads.threadsafe;

public class VolatileFields {

	// This value will be stored in the main memory, and never will be recovery from de CPU cache;
	private volatile int counter;
	// Embora apenas o counter seja volatile, uma Thread que tenha acesso aos campos dessa classe,
	// sempre irá recuperar o valor de todos os campos visíveis do main memory, um campo faz
	// os outros também serem armezenados na main memory;
	private String name;
}

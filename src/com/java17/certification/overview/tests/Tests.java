package com.java17.certification.overview.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

import com.topics.topic8.concurrency.TestCallable;

public class Tests {

	static Double d;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		System.out.format("%d \n", 1);
		System.out.printf("%d \n", 1);
		
		int balance = 1999;
		int interest = 10;
		int years = 5;
		
		int comp = balance * ((1 + interest / 100) * years -1 );
		
		int x = 3;
		int y = ++x * 4 / x-- + --x;
		
		System.out.println(x);
		System.out.println(y);
		
		
		int _5 = 10;
		int z = _5;
		
		System.out.println(_5 / z);
		
		
		Integer i = Integer.parseInt("-127");
		Integer j = i;
		i--;
		i++;
		System.out.println((i == j));
		
		
		short a = 10;
		System.out.println((a == 10));
		
		int aa, b, c; 
		
		//var CAN = new Locale.Builder().setLanguage("en").setRegion("ca").build();
		
		
		var listString = new ArrayList<String>();
		
		
		var list = new ArrayList<String>();
		list.add("One");
		list.add("On");
		list.add("Once");
		list.add("Ones");
		
		Predicate<String> p1 = s -> s.startsWith("");
		
		list.stream().filter(p1).forEach(s -> System.out.println());
		
		UnaryOperator<String> func = (low) -> low.toUpperCase();
		
		var myList = new ArrayList();
		myList.add(100);
		
		A aTest = new B();
		
		IntStream s = IntStream.range(1, 3);
		IntConsumer cons = System.out::print;
		IntConsumer cons2 = n -> System.out.println(++n);
		
		s.forEach(cons.andThen(cons2));
		
		var aList = new ArrayList<>();
		aList.parallelStream();
		
		Object obj;
		
		Files.find(null, a, null, null);
		
		
		// Forma de instanciar:
		Callable call = TestCallable::new;
		
		
		
		// Retorna o mínimo valor:
		Integer.min(0, 1);
		
		switch("a") {
			case "x" -> System.out.println("x"); 
		}
		
		Object o = new Object();
		switch (o) {
			case null -> System.out.println("null");
			case String s  -> System.out.println("String");
			default -> System.out.println("a");
		}
		
	}
}

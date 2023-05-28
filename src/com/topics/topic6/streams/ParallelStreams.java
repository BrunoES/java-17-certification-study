package com.topics.topic6.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ParallelStreams {
	/*
	 * https://www.baeldung.com/java-when-to-use-parallel-stream
	 * The number of threads in the common pool is equal to (the number of processor cores -1).
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Formas de se obter um stream paralelo:
		Stream<String> s1 = Stream.of("a", "b", "c").parallel();
		
		Stream<String> s2 = List.of("a", "b", "c").parallelStream();
		
		Stream<String> s3 = Set.of("a", "b", "c").parallelStream();
	
		// Podemos notar diferentes workers printando o valor:
		s1.forEach(number ->
	    	System.out.println(number + " " + Thread.currentThread().getName())
		);
		
		
		// Calculando uma soma:
		List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
		int sum = listOfNumbers.parallelStream().reduce(5, Integer::sum);
		System.out.println(sum);
	}

}

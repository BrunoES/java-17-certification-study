package com.topics.topic6.streams;

import java.io.IOException;
import java.util.stream.Stream;

public class StreamsHandlingExceptions {
	
	public static void main(String[] args) {
		Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5);
		s1.filter(i -> StreamsHandlingExceptions.isPar(i)).forEach(System.out::print);
		
		// Caso o método retorne uma exception, precisa ser tratada dentro do bloco.
		Stream<Integer> s2 = Stream.of(1, 2, 3, 4, 5);
		s2.filter(i -> {
			boolean result = false;
			try {
				result = StreamsHandlingExceptions.isParWithThrows(i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				return result;
			}
		}).forEach(System.out::print);
	}
	
	public static boolean isPar(int num) {
		return num % 2 == 0;
	}
	
	public static boolean isParWithThrows(int num) throws IOException {
		return num % 2 == 0;
	}

}

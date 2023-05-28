package com.topics.topic6.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsMethods {
	
	public static void main(String[] args) {
		reduce();
		peek();
		concat();
		sorted();
		map();
		flatMap();
		filter();
	}
	
	
	/*
	 * Reduz ou resumo o stream à um valor específico.
	 */
	public static void reduce() {
		System.out.println("\n reduce");
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int result = numbers
		  .stream()
		  .reduce(0, (subtotal, element) -> subtotal + element);
		System.out.println(result);
		
		// com Parallel Stream, da na mesma.
		List<String> latters = Arrays.asList("a", "b", "c");
		String concat = latters.parallelStream().reduce("z", String::concat);
		System.out.println(concat);
	}
	
	/*
	 * Um método apenas para debug ou log, não possui uma função específica
	 */
	public static void peek() {
		System.out.println("\n peek");
		
		// Sem um método terminal, não gera nenhuma saída:
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		numbers.stream().peek(System.out::print);
		
		// Com um método terminal, executa o peek:
		numbers.stream().peek(System.out::print).collect(Collectors.toList());

		Stream.of("one", "two", "three", "four")
		  .filter(e -> e.length() > 3)
		  .peek(e -> System.out.println("Filtered value: " + e))
		  .map(String::toUpperCase)
		  .peek(e -> System.out.println("Mapped value: " + e))
		  .collect(Collectors.toList());
	}
	
	/*
	 * Método static da classe Stream, Faz o merge de 2 ou mais streams
	 */
	public static void concat() {
		System.out.println("\n concat");
		
		Stream<Integer> s1 = Stream.of(1, 2, 3);
		Stream<Integer> s2 = Stream.of(4, 5, 6, 1, 2, 3);
		
		// Concatena os streams, inclusive repetindo valores, se houver.
		//Stream.concat(s1, s2).forEach(System.out::print);
		
		// Concatenando 3 streams.
		Stream<Integer> s3 = Stream.of(9, 12);
		Stream.concat(Stream.concat(s1, s2), s3).forEach(System.out::print);
	}
	
	/*
	 * Método que ordena um stream
	 */
	public static void sorted() {
		System.out.println("\n sorted");
		
		Stream<Integer> s1 = Stream.of(9, 5, 7, 1, 6, 4, 2);
		s1.sorted().forEach(System.out::print);
		
		// Irá lançar uma ClassCastException pois Object não é um Comparable.
		Stream<Object> s2 = Stream.of(new Object(), new Object());
		// s2.sorted().forEach(System.out::print);
		
		// Vamos supor que este stream abaixo fosse um Stream de objetos que não são Comparables, então temos que prover uma forma de comparação.
		Stream<Integer> s3 = Stream.of(9, 5, 7, 1, 6, 4, 2);
		s3.sorted((i1, i2) -> i1.compareTo(i2)).forEach(System.out::print);
	}
	
	/*
	 * Aplica uma função para cada elemento do Stream, e retorna um novo Stream.
	 * The map() function is a fundamental operation in the Streams API. It takes a Function<T, R>
	 * as an argument and applies it to each element of the stream,
	 * producing a new stream of type Stream<R>. The Function<T, R> interface has a single method,
	 * apply(T t), that takes an argument of type T and returns a value of type R
	 */
	public static void map() {
		System.out.println("\n map");
		
		List<String> fruits = Arrays.asList("apple", "banana", "cherry");
		fruits.stream().map(String::length).forEach(System.out::print);
	}
	
	/*
	 * The flatMap() function is similar to map(), but it has a different signature: it takes a
	 * Function<T, Stream<R>> as an argument and produces a stream of type Stream<R>. The Function<T, Stream<R>>
	 * interface has a single method, apply(T t), that takes an argument of type T and returns a stream of type Stream<R>.
	 * Here is an example of using the flatMap() function to transform a list of strings into a stream of their characters:
	 * The main difference between map() and flatMap() is that map() transforms each element of a stream
	 * into a single element of a new stream, while flatMap() transforms each element of a stream into a
	 * stream of multiple elements. Another difference is that the result of map() is always a stream of
	 * the same type as the original stream, while the result of flatMap() may be a stream of a different type.
	 */
	public static void flatMap() {
		System.out.println("\n flatMap");
		
		Stream<String> s1 = Stream.of("Teste1", "Teste2", "Teste3");
		
		Character[] ar = {'a', 'b', 'c'};
		Stream<Character> s0 = Stream.of(ar);
		
		
		// Retorna um Stream de Stream de char
		s1.flatMap(s -> s.chars().mapToObj(c -> (char)c)).forEach(System.out::print);
	}
	
	/*
	 * 
	 */
	public static void filter() {
		System.out.println("\n filter");
		
		Stream<String> s1 = Stream.of("Teste1", "Teste2", "Teste3");
		s1.filter(s -> s.startsWith("T")).forEach(System.out::print);
		
		System.out.println();
		
		Stream<String> s2 = Stream.of("Teste4", "Teste5", "Teste6");
		s2.filter(s -> s.startsWith("T") && (s.length() == 6)).forEach(System.out::print);
	}

}

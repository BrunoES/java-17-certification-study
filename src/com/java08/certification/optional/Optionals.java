package com.java08.certification.optional;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.Stream;

public class Optionals {

	public static void main(String[] args) {
		Optional<Integer> numero = Optional.of(1);
		Optional<Integer> numero2 = Optional.empty();
		Optional<Integer> numero3 = Optional.ofNullable(1);
		Optional<Integer> numero4 = Optional.ofNullable(null);
		
		numero.isPresent();
		numero2.isPresent();
		
		System.out.println(numero.get());
		// System.out.println(numero2.get()); // No value present NoSuchElementException
		
		numero.ifPresent(x -> System.out.println(x));
		numero2.ifPresent(x -> System.out.println(x));
		
		System.out.println(numero2.orElse(2));
		System.out.println(numero2.orElseGet(() -> 3));
		//System.out.println(numero2.orElseThrow());
		
		
		Optional<Integer> num = Stream.of(1, 2, 3).findFirst(); // Retorna um Optional de Inteiro
		System.out.println(num.get());
		
		Stream.of(1, 2, 3).findFirst().ifPresent(x -> System.out.println(x));
		Stream.of(1, 2, 3).findFirst().ifPresent(System.out::println);
		
		OptionalInt.of(1);
		OptionalDouble.of(1.23);
		OptionalLong.of(1L);
	}

}

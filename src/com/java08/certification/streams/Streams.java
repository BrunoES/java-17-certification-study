package com.java08.certification.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4);

		// Stream
		// Operações intermediarias:
		list.stream()
		.filter(e -> e > 0)
		.skip(2)
		.limit(5)
		.distinct()
		.map(e -> e * 1)
		.forEach(e -> System.out.println(e));

		// Operações finais:
		int count = (int) list.stream().count();
		
		Optional<Integer> min = list.stream()
		.min(Comparator.naturalOrder());
		
		Optional<Integer> max = list.stream()
		.max(Comparator.naturalOrder());
		
		List list2 = list.stream()
		.collect(Collectors.toList());
		
		Map<Boolean, List<Integer>> groupingByParEImpar = list.stream()
		.collect(Collectors.groupingBy(e -> e % 2 == 0));
		
		Map<Integer, List<Integer>> groupingByRestoDaDivisao = list.stream()
				.collect(Collectors.groupingBy(e -> e % 3));
		
		list.stream()
		.map(e -> String.valueOf(e))
		.collect(Collectors.joining());
		
		list.stream()
		.map(e -> String.valueOf(e))
		.collect(Collectors.joining(";"));
	}

}

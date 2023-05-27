package com.topics.topic6.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		groupingBy();
	}
	
	/*
	 * Agrupa o restulado coletado de um stream, por um atributo específico ou resultado de uma function específica, ou coletor específico.
	 * https://www.baeldung.com/java-groupingby-collector
	 */
	public static void groupingBy() {
		System.out.println("\n groupingBy");
		
		// Converte o resultado de um stream em um Map de List de valores por um campo específico.
		Stream<Person> s1 = Stream.of(new Person("Bruno", 27, PersonType.NORMAL), new Person("Gabriela", 25, PersonType.COMPORATION));
		Map<PersonType, List<Person>> personByType = s1.collect(Collectors.groupingBy(Person::getType));
		personByType.forEach((k, v) -> System.out.println(k + " - " + v.get(0).getName()));

		System.out.println();
		
		// Particiona o resultado mediante um predicate: Se a pessoa for do tipo "Normal", será true.
		Stream<Person> s2 = Stream.of(new Person("Bruno", 27, PersonType.NORMAL), new Person("Gabriela", 25, PersonType.COMPORATION));
		Map<Boolean, List<Person>> personPartitionedByType = s2.collect(Collectors.partitioningBy(p -> PersonType.NORMAL.equals(p.getType())));
		personPartitionedByType.forEach((k, v) -> System.out.println(k + " - " + v.get(0).getName()));
		
	}

}

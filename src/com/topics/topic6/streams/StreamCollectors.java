package com.topics.topic6.streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		groupingBy();
		partitionBy();
		collectorsMapping();
		collectorsCounting();
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
		personByType.forEach((k, v) -> System.out.println(k + " - " + v));

		System.out.println();
		
		// Converte o resultado de um stream em um Map de Set de valores por um campo específico.
		Stream<Person> s2 = Stream.of(new Person("Bruno", 27, PersonType.NORMAL), new Person("Gabriela", 25, PersonType.COMPORATION));
		Map<PersonType, Set<Person>> mapSetPersonByType = s2.collect(Collectors.groupingBy(Person::getType, Collectors.toSet()));
		mapSetPersonByType.forEach((k, v) -> System.out.println(k + " - " + v));
		
		System.out.println();
		
		// Particionando por múltiplos campos:
		// Converte o resultado de um stream em um Map de List de valores por um campo dois campos.
		Stream<Person> s3 = Stream.of(new Person("Bruno", 27, PersonType.NORMAL), new Person("Gabriela", 25, PersonType.COMPORATION));
		Map<PersonType, Map<String, List<Person>>> personByTypeAndName = s3.collect(Collectors.groupingBy(Person::getType, Collectors.groupingBy(Person::getName)));
		personByTypeAndName.forEach((k, v) -> System.out.println(k + " - " + v));
		
	}
	
	/*
	 * Particiona o restulado coletado de um stream, por um atributo específico ou resultado de uma function específica, ou coletor específico.
	 * https://www.baeldung.com/java-groupingby-collector
	 */
	public static void partitionBy() {
		System.out.println("\n partitionBy");
		
		// Particiona o resultado mediante um predicate: Se a pessoa for do tipo "Normal", será true.
		Stream<Person> s1 = Stream.of(new Person("Bruno", 27, PersonType.NORMAL), new Person("Gabriela", 25, PersonType.COMPORATION));
		Map<Boolean, List<Person>> personPartitionedByType = s1.collect(Collectors.partitioningBy(p -> PersonType.NORMAL.equals(p.getType())));
		personPartitionedByType.forEach((k, v) -> System.out.println(k + " - " + v.get(0).getName()));
		
	}
	
	/*
	 * Mapeia o resultado de um stream
	 * https://www.baeldung.com/java-groupingby-collector
	 */
	public static void collectorsMapping() {
		System.out.println("\n collectorsMapping");
		
		Stream<String> s1 = Stream.of("a", "b", "c");
		List<String> list = s1.collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));
		System.out.println(list);
	}
	
	/*
	 * Conta o resultado de um stream
	 */
	public static void collectorsCounting() {
		System.out.println("\n collectorsCounting");
		
		Stream<String> s1 = Stream.of("a", "b", "c");
		Long length = s1.collect(Collectors.counting());
		System.out.println(length);
	}
	

}
 
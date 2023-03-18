package com.java12.certification.overview;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java12 {

	public static void main (String[] args) {
		
		// String blocks removidos dessa forma na jdk 12:
		// String teste = `teste`;
		/*
		String html = `<html>
				        <body>
				            <p>Hello World.</p>
				        </body>
				    </html>
				   `;
				   */
		
		// Switch case:
		String day = "MON";
		int dayNumber = switch (day) {
			case "MON"-> 1;
			case "TUE" -> 2;
			case "WED" -> 3;
			default -> 0;
		};
		
		
		
		// Switch case com return de valor
		int i =  switch (day) {
			case "MONDAY", "FRIDAY", "SUNDAY" -> 1;
			case "TUESDAY" -> 2;
			case "WEDNESDAY" -> 3;
			default -> 0; // Default se torna obrigatório.
		};
		
		// Switch case com bloco
		switch (day) {
			case "MONDAY", "FRIDAY", "SUNDAY" -> System.out.println(1);
			case "TUESDAY" -> System.out.println(2);
			case "WEDNESDAY" -> {
					String teste = "Trecho de código...";
					System.out.println(teste);
					System.out.println(3);
			}
		}
	
		
		// New String methods
		// indent:
		String code = "int i = 0 ....";
		String code0 = code.indent(0); // remove spaces at the beginning of each line
		String code1 = code.indent(1); // add spaces at the beginning of each line
		System.out.println(code0);
		System.out.println(code1);
		
		// transform:
		String text = "test";
		String transformedTest0 = text.transform(x -> x.trim()); // expect a function parameter to transform the result string.
		String transformedTest1 = text.transform(x -> new StringBuilder(x).reverse().toString());
		System.out.println(transformedTest0);
		System.out.println(transformedTest1);
		
		// Teeing Collector
		// Exemplo:
		/*
		 * Um novo collector "Tee" (adaptador), foi adicionado. Permite que seja passada duas funções como parâmetro,
	 	 * por exemplo: Uma função de soma, e outra função de contador, possibilitando um merge das funções, aplicando 
		 * uma média como resultado, exemplo:
		 */
		double mean = Stream.of(1, 2, 3, 4, 5)
			      .collect(Collectors.teeing(Collectors.summingDouble(Integer::valueOf), 
			        Collectors.counting(), (sum, count) -> sum / count));
		
		
		// Compact Number Formatting:
		NumberFormat nf1 = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
		NumberFormat nf2 = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
		
		/* Exemplos:
		 * Locale US:
		 * SHORT: 10k
		 * LONG:  10 thousand
		 */
		System.out.println(nf1.format(10000));
		System.out.println(nf2.format(10000));
		
	}
}

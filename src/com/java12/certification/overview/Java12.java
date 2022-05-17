package com.java12.certification.overview;

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
		String day = "MONDAY";
		switch (day) {
			case "MONDAY", "FRIDAY", "SUNDAY" -> System.out.println(1);
			case "TUESDAY" -> System.out.println(2);
			case "WEDNESDAY" -> System.out.println(3);
		}
		
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
		
	}
}

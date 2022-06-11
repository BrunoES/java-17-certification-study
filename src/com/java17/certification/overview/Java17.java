package com.java17.certification.overview;

import java.time.DayOfWeek;

public class Java17 {

	public static void main (String[] args) {
		
		// Pattern Matchings em switchs
		
		DayOfWeek day = DayOfWeek.MONDAY; // Assign here the value
	     System.out.println(switch (day) {
	         case SUNDAY, SATURDAY -> "Weekend";
	         case FRIDAY, THURSDAY, WEDNESDAY, TUESDAY, MONDAY -> "Weekday";
	     });
	     
	     System.out.println(switch (day) {
	         case SUNDAY, SATURDAY -> "Weekend";
	         case FRIDAY, THURSDAY, WEDNESDAY, TUESDAY, MONDAY -> {
	        	 // faz uma a��o no bloco / processamento, e yield retorna o valor
	        	 yield "Weekday";
	         }
	     });
	     
	     // Um benef�cio das Selead classes, � que � poss�vel que o compilador saber� se todos os casos
	     // poss�veis, de uma valida��o de tipo de classe foi cumprida ou n�o, obrigando ou n�o a implementa��o
	     // de um default;
	     /*
	      public String test(Object obj) {
		    return switch(obj) {
			    case Integer i -> "It is an integer";
			    case String s -> "It is a string";
			    case House s -> "It is a house";
			    default -> "It is none of the known data types";
		    };
		     
		}
	      */
	     
	     test("a");
	}
	 public static String test(Object obj) {
		return switch(obj) {
			case Integer i -> "It is an integer";
			case String s -> "It is a string";
			case House s -> "It is a house";
			default -> "It is none of the known data types";
		};
			
	}
}

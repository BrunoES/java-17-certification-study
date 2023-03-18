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
	        	 // faz uma ação no bloco / processamento, e yield retorna o valor
	        	 yield "Weekday";
	         }
	     });
	     
	     // Um benefício das Selead classes, é que é possível que o compilador saberá se todos os casos
	     // possíveis, de uma validação de tipo de classe foi cumprida ou não, obrigando ou não a implementação
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
	     
	    // test("a");
	}
	
	/*
	 public static String test(Object obj) {
		    return switch(obj) {
			    case Integer i -> "It is an integer";
			    case String s -> "It is a string";
			    case House s -> "It is a house";
			    default -> "It is none of the known data types";
		    };
		     
		}
	*/
}

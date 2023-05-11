package com.topics.topic2.controlprogrammingflow;

public class SwitchCases {

	public static void main(String[] args) {
		String s = "A";
		
		// N�o precisa ter default
		switch(s) {
			case "A":
				System.out.println("A");
				break;
			case "B":
				System.out.println("B");
				break;
		}
		
		
		// N�o precisa ter break
		switch(s) {
			case "A":
				System.out.println("A");
			case "B":
				System.out.println("B");
		}
		
		// mesmo tendo o default antes, ele n�o entra no default primeiro.
		switch(s) {
		default:
			System.out.println("default");
			break;
		case "A":
			System.out.println("A");
		case "B":
			System.out.println("B");
			break;
		}
		
		// mas se o default estiver depois de uma condi��o que foi satisfeita sem break, ele vai continuar e entrar no default
		switch(s) {
		case "A":
			System.out.println("A");
		case "B":
			System.out.println("B");
		default:
			System.out.println("default");
			break;
		}
		
		final String test = "";
		// N�o pode ter uma vari�vel que n�o seja final (constante) nos cases, para usar uma vari�vel no case, tem que ser uma constante.
		switch(s) {
			case test:
				System.out.println("A");
				break;
			case "B":
				System.out.println("B");
				break;
		}
		
		// Switch expressions, tamb�m n�o precisam de default, a n�o ser que tenham um return, como abaixo.
		switch(s) {
			case "A" -> System.out.println("A"); 
		}
		
		// Precisa ter um default, se comentarmos o default, vai falhar a compila��o.
		var result = switch(s) {
		    case "A" -> 3;
		    case "B" -> 1;
		    case "C" -> 2;
		    default -> 0;
		};
		
	}
	
}

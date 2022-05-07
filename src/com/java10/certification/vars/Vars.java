package com.java10.certification.vars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vars {
	
	// N�o podemos ter var em atributos de classe
	// var nome = "Teste";
	
	public static void main(String[] args) {
		var var1 = "a";
		var nomes = List.of("a", "b", "c");
		var lista = new ArrayList<Integer>();
		
		try(var r1 = new Scanner("Teste")) {
		} catch(Exception e ) {
		}
		
		// Cuidado pois n�o est� claro o tipo
		var nome = getNome();

		// Cuidado pois n�o est� claro o tipo
		for(var elemento : lista) {
		}
		
		// int
		for(var i = 0; i < 50; i ++) {
		}
		
		// Long
		for(var i = 0L; i < 50; i ++) {
		}
		
		// var teste; // N�o compila, porque precisa ser inicializada para o tipo ser inferido.
		// var teste = null; // N�o compila, porque precisa ser inicializada para o tipo ser inferido.
		
		// Declara��o de uma Lambda:
		// Funciona
		Runnable r = () -> System.out.println("Teste");
		
		// N�o Funciona pois o Java precisa saber qual a implementa��o do �nico m�todo abstrato dentro da interface Runnable
		//var r = () -> System.out.println("Teste");
		
		
		
		/*
		try {
		//} catch(var e) { Tamb�m n�o pode em Catchs 
		}
		*/

		
		// Isso � poss�vel
		var var = new Var();
		
		
		
		// Isto n�o � mais um List, mas sim um ArrayList
		var lista1 = new ArrayList<>(); // List de Object 
		
		// Isto n�o � mais um List, mas sim um ArrayList
		var lista2 = new ArrayList<String>(); // List de String
		
		
		
		// Var Intersection Type
		var StringOuInteger = 1 == 1 ? "ABC" : 23;
		System.out.println(StringOuInteger);
		
	}
	
	public static String getNome() {
		return "";
	}
	
	/* N�o funciona como tipo de retorno
	public static var getNome() {
		return "";
	}
	*/
	
	/* Tamb�m n�o funciona em declara��o de par�metro
	public static void setNome(var nome) {
		// TO DO
	}
	*/
	
	/* Tamb�m n�o funciona em construtores
	public Vars(var teste) {
		// TO DO
	}
	*/

	
	
	
	// Assim Pode
	static class Var {
		
	}
	
	/* Assim n�o pode
	static class var {
		
	}
	*/
	
}

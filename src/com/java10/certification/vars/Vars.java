package com.java10.certification.vars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vars {
	
	// Não podemos ter var em atributos de classe
	// var nome = "Teste";
	
	public static void main(String[] args) {
		var var1 = "a";
		var nomes = List.of("a", "b", "c");
		var lista = new ArrayList<Integer>();
		
		try(var r1 = new Scanner("Teste")) {
		} catch(Exception e ) {
		}
		
		// Cuidado pois não está claro o tipo
		var nome = getNome();

		// Cuidado pois não está claro o tipo
		for(var elemento : lista) {
		}
		
		// int
		for(var i = 0; i < 50; i ++) {
		}
		
		// Long
		for(var i = 0L; i < 50; i ++) {
		}
		
		// var teste; // Não compila, porque precisa ser inicializada para o tipo ser inferido.
		// var teste = null; // Não compila, porque precisa ser inicializada para o tipo ser inferido.
		
		// Declaração de uma Lambda:
		// Funciona
		Runnable r = () -> System.out.println("Teste");
		
		// Não Funciona pois o Java precisa saber qual a implementação do único método abstrato dentro da interface Runnable
		//var r = () -> System.out.println("Teste");
		
		
		
		/*
		try {
		//} catch(var e) { Também não pode em Catchs 
		}
		*/

		
		// Isso é possível
		var var = new Var();
		
		
		
		// Isto não é mais um List, mas sim um ArrayList
		var lista1 = new ArrayList<>(); // List de Object 
		
		// Isto não é mais um List, mas sim um ArrayList
		var lista2 = new ArrayList<String>(); // List de String
		
		
		
		// Var Intersection Type
		var StringOuInteger = 1 == 1 ? "ABC" : 23;
		System.out.println(StringOuInteger);
		
	}
	
	public static String getNome() {
		return "";
	}
	
	/* Não funciona como tipo de retorno
	public static var getNome() {
		return "";
	}
	*/
	
	/* Também não funciona em declaração de parâmetro
	public static void setNome(var nome) {
		// TO DO
	}
	*/
	
	/* Também não funciona em construtores
	public Vars(var teste) {
		// TO DO
	}
	*/

	
	
	
	// Assim Pode
	static class Var {
		
	}
	
	/* Assim não pode
	static class var {
		
	}
	*/
	
}

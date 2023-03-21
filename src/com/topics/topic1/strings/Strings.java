package com.topics.topic1.strings;

import java.util.List;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		intern();
		compareTo();
		format();
		subStringXSubSequence();
		indexOf();
		join();
		charSequence();
		curiosidades();
	}
	
	/*
	 * 
	 * 	Caso já exista uma string com aquele mesmo conteúdo (ou que satisfaça o método equals()),
	 * o valor retornado será o objeto correspondente já existente.
	 */
	
	public static void intern() {
		System.out.println("\nintern:");
		
		String str1=new String("hello");  
		String str2="hello";  
		String str3=str1.intern();//returns string from pool, now it will be same as s2  
		System.out.println(str1==str2);//false because reference variables are pointing to different instance  
		System.out.println(str2==str3);//true because reference variables are pointing to same instance  
		
        String s1 = "Javatpoint";  
        String s2 = s1.intern();  
        String s3 = new String("Javatpoint");  
        String s4 = s3.intern();
        System.out.println(s1==s2); // True  
        System.out.println(s1==s3); // False  
        System.out.println(s1==s4); // True       
        System.out.println(s2==s3); // False  
        System.out.println(s2==s4); // True        
        System.out.println(s3==s4); // False        
	}
	
	/*
	 * Compara lexograficamente se uma String é maior que a outra, exemplo:
	 * abcd > abc
	 * abc = abc
	 * hello > Hello (porque minúsculas vem depois de maiúsculas na tabela ASCII)
	 */
	public static void compareTo() {
		System.out.println("\ncompareTo:");
		
		System.out.println("abcd".compareTo("abc"));
		System.out.println("abc".compareTo("abc"));
		System.out.println("hello".compareTo("hello"));
	}
	
	/*
	 * %s = Substitui string passada por parâmetro após String.
	 * %d  = Substitui número passado por parâmetro após String.
	 * %2$s %1$s = Substitui conteúdo passado, respeitando o index 2 e 1 neste caso, exemplo:
	 * String string = String.format("Welcome to %2$s%1$s century", "st", 21);
	 * Saída: Welcome to 21st century
	 */
	public static void format() {
		System.out.println("\nformat:");
		
		// Format convencional.
		String s1 = String.format("Apenas o %s teste de numero %d", "primeiro", 1);
		System.out.println(s1);
		
		// Inserindo ordem no format.
		String s2 = String.format("Apenas o %2$d teste de numero %1$s", "primeiro", 1);
		System.out.println(s2);
	}
	
	/**
	 * Diferença, substring x subSequence:
	 * String.substring(begin, numberOfChars)
	 * String.subSequence(begin, end);
	 */
	public static void subStringXSubSequence() {
		System.out.println("\nsubStringXSubSequence:");
		
		String s1 = "Testeee";
		System.out.println(s1.substring(0, 3));
		
		String s2 = "Testeee";
		System.out.println(s1.subSequence(0, 3));
	}
	
	/*
	 * String.join: Une os itens de uma coleção separados pelo char passado no primeiro parâmetro:
	 * obs: Não é aceito array no parâmetro.
	 */
	public static void join() {
		System.out.println("\njoin:");
		
		String string1  = String.join("-", "a", "b");
		String string2  = String.join("-", List.of("a", "b"));
		String string3  = String.join("-", new StringBuilder("a"), new StringBuilder("b"));
		
		System.out.println(string1);
		System.out.println(string2);
		System.out.println(string3);
	}
	
	/*
	 * Procura pelo char, portanto, maíusculo e minúsculas faz diferença, retorna o primeiro indice encontrado:
	 */
	public static void indexOf() {
		System.out.println("\nindexOf:");
		
		String s1 = "Teste"; 
		int index = s1.indexOf('e');
		System.out.println(index);
		
		index = s1.indexOf('s');
		System.out.println(index);
	}
	
	/*
	 * String is a sequence of characters in Java. It is an immutable class and one of the most frequently used types in Java.
	 * This class implements the CharSequence, Serializable, and Comparable<String> interfaces.
	 * Let's compare the differences and commonalities of CharSequence and String. They both reside in the same package named java.lang.,
	 * but the former is an interface and latter is a concrete class. Moreover, the String class is immutable.
	 * In the following example, each sum operation creates another instance, increases the amount of data stored and returns the most recently created String
	 */
	public static void charSequence() {
		System.out.println("\ncharSequence:");
		// Char sequence é uma interface, possibilita polimorfismo sobre classes String.
		CharSequence s1 = new String("Teste");
		CharSequence s2 = new StringBuilder("Teste");
		CharSequence s3 = new StringBuffer("Teste");
		
		// Both instantiations create Strings with the same content. However, they are not equal to each other:
		System.out.println(s1.equals(s2)); // false
		System.out.println(s1.equals(s2.toString())); // true
	}
	
	public static void curiosidades() {
		System.out.println("\ncuriosidades:");
		
		/*
		 * Ao concatenar uma string null com um valor string qualquer, o resultado será null+novoValor, exemplo: 
		 */
		
		String string1 = null;
		string1 += "teste";
		System.out.println(string1);
		
		/*
		 * isEmpty : Se de fato a string está vazia, se tiver caracteres ocultos, não é empty ( \t \n) ""
		 * isBlank : Se o texto é vazio, mesmo que tenha outros caracteres, por exemplo: \t \n
		 */
		
		String string2 = "";
		String string3 = "\n";
		
		System.out.println(string2.isBlank());
		System.out.println(string2.isEmpty());
		
		System.out.println(string3.isBlank());
		System.out.println(string3.isEmpty());
		
		/*
		 * Caso já exista uma string, com valor definido previamente, inicializada antes, e uma outra String é criada com  o mesmo valor,
		 * então é reaproveitada a referência deste valor em memória, e ambos os objetos passam a ter a mesma referência, exemplo:
		 */
		
		String s1 = new String("ja") + new String("va");
		String s2 = "ja" + "va";
		String s3 = "java";
		String s4 = new String("java");
		String s5 = "java";
		
		System.out.println(s2 == s3); // s2 e s3 apontam para a mesma referência
		System.out.println(s1 == s2); // s1 e s2 não, apontam para a mesma referência, pois o new String no Ja, e no Va, criaram duas instâncias, para depois concatenar.
		System.out.println(s4 == s1); // s4 também não aponta para nenhuma outra referência igual;
		System.out.println(s3 == s5); // s3 e s5 apontam para a mesma referência;
	}

}

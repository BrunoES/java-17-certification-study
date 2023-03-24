package com.topics.topic1.strings;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.IntStream;

// https://javaconceptoftheday.com/java-new-string-methods-with-examples/
// https://www.edureka.co/blog/java-string/
// https://www.javatpoint.com/java-string
public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chars(); // JDK9
		codePoints(); // JDK9
		intern();
		compareTo();
		format();
		subStringXSubSequence();
		indexOf();
		join(); // JDK8
		charSequence();
		lines(); // JDK11
		repeat(); // JDK11
		strip(); // JDK11 (stripIndent() // JDK15)
		indent(); // JDK12
		translateEscapes(); // JDK15
		transform(); // JDK12
		describeConstable(); // JDK12
		resolveConstantDesc(); // JDK12
		formatted(); // JDK15
		curiosidades();
		
		// Outros:
		// endsWith(), getBytes().
	}
	
	/*
	 * chars: Retorna um IntStream com os codePoints (código ASCII) dos chars.
	 */
	public static void chars() {
		System.out.println("\nchars:");
		
        String s1 = "hello-stream";

        // use the chars method to get a stream of char values
        IntStream codePointStream = s1.chars();

        // convert the code points back to characters and print the output
        codePointStream.mapToObj(Character::toChars).forEach(System.out::println);
        // Obs: Character.toChars converte um int num char.
	}
	
	/*
	 * codePoints: Retorna um IntStream com os codePoints (Suporta Unicode) dos chars.
	 */
	public static void codePoints() {
		System.out.println("\ncodePoints:");
		
		String s1 = "teste";
		
		IntStream codePointStream = s1.codePoints();

        // convert the code points back to characters and print the output
        codePointStream.mapToObj(Character::toChars).forEach(System.out::println);
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
	
	/*
	 * lines: Retorna um stream com as linhas da String
	 */
	public static void lines() {
		System.out.println("\nlines:");
		
		String s1 = "Teste \n Teste";
		
		// Número de linhas:
		System.out.println(s1.lines().count());
		
		// Printando linhas:
		s1.lines().forEach(x -> System.out.println(x));
	}
	
	/*
	 * repeat: Retorna um stream com as linhas da String
	 */
	public static void repeat() {
		System.out.println("\nrepeat:");
		
		String s1 = "Teste";
		
		System.out.println(s1.repeat(5));
		
		System.out.println(s1); // Não muda o valor da String
	}
	
	/*
	 * strip: trim melhorado com novos caracteres unicode que representam espaço em branco
	 * stripLeading: Remove espaços em branco apenas da frente
	 * stripTrailing: Remove espaços em branco apenas do fim
	 */
	public static void strip() {
		System.out.println("\nstrip:");
		
		// You can use this method to remove all leading and trailing white spaces of the given string:
        System.out.println("   1   ".strip());
        System.out.println("\t A \t".strip());
        System.out.println("\n A1 \n".strip());
        System.out.println("1   A".strip());
        System.out.println("-------");
        System.out.println("a   ".stripTrailing());
        System.out.println("   a".stripLeading());
        System.out.println("-------");
      
        String s1 = "	String teste = \"teste\";";
        // Remove a identação dos blocos
        // Não muda valor da String, precisa atribuir
        System.out.println(s1.stripIndent());
	}
	
	/*
	 * translateEscapes: Aplica os caracteres escapados, como \\n, \\t, etc.
	 * Obs: Apenas escapados. 
	 */
	public static void translateEscapes() {
		System.out.println("\ntranslateEscapes:");
		
		String s1 = "Hey, \\n This is not normally a line break.";
		
		System.out.println(s1);
		System.out.println(s1.translateEscapes());
	}
	
	/*
	 * ident: Identa uma String mediante um número de espaços
	 */
	public static void indent() {
		System.out.println("\nindent:");
		
		String s1 = "123\nabc\nABC";
		
		System.out.println(s1.indent(1)); // identa com 1 espaço
		System.out.println(s1.indent(4)); // identa com 4 espaços
	}
	
	/*
	 * transform: Aplica uma função à String.
	 */
	public static void transform() {
		System.out.println("\ntransform:");
		
		String s1 = "teste";
		
		System.out.println(s1.transform(x -> x.toUpperCase()));
		System.out.println(s1.transform(String::toUpperCase));
	}

	/*
	 * describeConstable: retorna um Optional<String>
	 * From Java 12, String class implements two more interfaces – Constable and ConstantDesc.
	 * From these two interfaces, String class inherits two more methods – describeConstable()
	 * from Constable and resolveConstantDesc() from ConstantDesc.
	 */
	public static void describeConstable() {
		System.out.println("\ndescribeConstable:");
		
		String s1 = "teste";
		
		System.out.println(s1.describeConstable().get());
	}
	
	/*
	 * resolveConstantDesc: Permite aplicar MehodHandles à uma String à partir do resolveConstantDesc 
	 * From Java 12, String class implements two more interfaces – Constable and ConstantDesc.
	 * From these two interfaces, String class inherits two more methods – describeConstable()
	 * from Constable and resolveConstantDesc() from ConstantDesc.
	 */
	public static void resolveConstantDesc() {
		System.out.println("\nresolveConstantDesc:");
		
		String s1 = "teste";
		
		System.out.println(s1.resolveConstantDesc(MethodHandles.lookup()));
	}
	
	/*
	 * formatted: versão 'não estática' do método já conhecido, String.format().
	 */
	public static void formatted() {
		System.out.println("\nformatted:");
		
		// formatted:
		String s1 = "1) %s 2) %s 3) %s".formatted("Java", "Python", "JavaScript");
		
		// format:
		String s2 = String.format("1) %s 2) %s 3) %s", "Java", "Python", "JavaScript");
		
		System.out.println(s1);
		System.out.println(s2);
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
		
		System.out.println(string2.isBlank()); // JDK11
		System.out.println(string2.isEmpty());
		
		System.out.println(string3.isBlank()); // JDK11
		System.out.println(string3.isEmpty());
		
		/*
		 * Caso já exista uma string, com valor definido previamente, inicializada antes, e uma outra String é criada com  o mesmo valor,
		 * então é reaproveitada a referência deste valor em memória, e ambos os objetos passam a ter a mesma referência, exemplo:
		 * Java String Pool: Java String pool refers to collection of Strings which are stored in heap memory. In this,
		 * whenever a new object is created, String pool first checks whether the object is already present in the pool or not.
		 * If it is present, then same reference is returned to the variable else new object will be created in the String pool
		 * and the respective reference will be returned
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

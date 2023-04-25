package com.topics.topic1.numbers;

public class Numbers {
	
	public static void main(String [] args) {
		
		// Int to short:
		byte x = 1;
		//short s = 3 + x; Compilação falha pois na operação, o compulador converte x em int
		// e não é possível converter int para short.
		// Compiler consider any number literal as int whitch is in int range)

		
		// Float: Sufixo f;
		// Float: No java, por padrão todo número fracionado é double, porém com o sufixo f, a gente diz que ele tem que ser float.
		var num = 3f;
		System.out.println(num);
		
		// valueOf - Retorna boolean
		Integer a = Integer.valueOf("1");
		// parseInt - Retorna int
		int b = Integer.parseInt("1");
		
		
		// Resultado = 1.5
		double a1 = 3.0 / 2;
		// Resultado = 1.0
		int a2 = 3 / 2;
		
		
		// Resultado: java.lang.ArithmeticException: / by zero
		// System.out.println( 0 / 0);
		// Resultado: NaN
		System.out.println( 0 / 0.0);
		
		
		// Dividindo o resto é positivo
		System.out.println(-10/-3);
		// -10%-3 - O mod não converte o valor para positivo ou negativo, não há "jogo de sinal"
		System.out.println(-10 % -3);
		
	}	

}

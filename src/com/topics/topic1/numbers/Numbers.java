package com.topics.topic1.numbers;

public class Numbers {
	
	public static void main(String [] args) {
		
		// Int to short:
		byte x = 1;
		//short s = 3 + x; Compila��o falha pois na opera��o, o compulador converte x em int
		// e n�o � poss�vel converter int para short.
		// Compiler consider any number literal as int whitch is in int range)

		
		// Float: Sufixo f;
		// Float: No java, por padr�o todo n�mero fracionado � double, por�m com o sufixo f, a gente diz que ele tem que ser float.
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
		
		
		// Dividindo o resto � positivo
		System.out.println(-10/-3);
		// -10%-3 - O mod n�o converte o valor para positivo ou negativo, n�o h� "jogo de sinal"
		System.out.println(-10 % -3);
		
		
		// Truncate de float e formata��o:
		var v1 = 7.77;
		var v2 = 8.67;
		var v3 = 9.97;
		System.out.printf("%.1f %.1f %.1f", v1, v2 , v3);
		
		// Cria Integer atrav�s de string, aceita decimal, hexadecimal e octal.
		Integer.decode("1");
		
		
		// Compara��o Integer x int
		Integer abc = 1;
		int abz = 1;
		System.out.println(abc == abz);
		// Retorna true pq abz � primitivo, ent�o o Java faz o unbox do Integer, e transforma ele em int.
	}	

}

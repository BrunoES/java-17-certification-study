package com.topics.mathapi;

public class MathApi {
	/*
	 * https://www.tutorialspoint.com/java/lang/java_lang_math.htm
	 */
	public static void main(String[] args) {
		double absDouble = Math.abs(2.7555);
		System.out.println(absDouble);

		long absLong = Math.abs(2L);
		System.out.println(absLong);
		
		// cosseno:
		double coss = Math.cos(90.0);
		System.out.println(coss);
		
		// seno:
		double seno = Math.sin(90.0);
		System.out.println(seno);
			
		// tangente:
		double tang = Math.tan(90.0);
		System.out.println(tang);
		
		// Arco cosseno:
		double arcCoss = Math.acos(90.0);
		System.out.println(arcCoss);
		
		// Arco seno:
		double arcSin = Math.acos(90.0);
		System.out.println(arcSin);
		
		// Arco tangente:
		double arcTang = Math.acos(90.0);
		System.out.println(arcTang);
		
		// Raiz cúbica:
		double raizCubica = Math.cbrt(27.0);
		System.out.println(raizCubica);
		
		// hipotenusa:
		double hypot = Math.hypot(2, 2);
		System.out.println(hypot);
		
		// logarítimo:
		double log = Math.log(10.00);
		System.out.println(log);
		
		// logarítimo com base 10:
		double log10 = Math.log10(10.00);
		System.out.println(log10);
		
		// maior número
		int max = Math.max(0, 1);
		System.out.println(max);
		
		// menor número
		int min = Math.min(0, 1);
		System.out.println(min);
		
		// portência:
		double pow = Math.pow(4, 2);
		System.out.println(pow);
		
		// round:
		double round = Math.round(2.7);
		System.out.println(round);
		
		// nextAfter:
		double nextAfter = Math.nextAfter(2.5, 2.51); // Retorna a casa decimal adjacente ao primeiro parâmetro em direação ao segundo parâmetro.
		System.out.println(nextAfter);
		
		// nextUp:
		double nextUp = Math.nextUp(2.5); // Retorna a casa decimal adjacente ao parâmetro em direação ao infinito.
		System.out.println(nextUp);
	}
	
}

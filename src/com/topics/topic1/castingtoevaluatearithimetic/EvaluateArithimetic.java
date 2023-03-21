package com.topics.topic1.castingtoevaluatearithimetic;

public class EvaluateArithimetic {

	public static void main (String[] args) {
		short x = 50;
		short y = 50;
		
		short w = (short) (x + y); // Isso compila
		//short z = (short) x + y;   // Isso não compila
		// o resultado de x + 1 é automaticamente afetado pelo auto promotion, para int
		// portanto, precisa ter um cast no resultado.
		
		int a = 50;
		int b = 50;
		
		int c = (int) ((a / b) * 1.0); // Isso compila
		// int c = ((a / b) * 1.0); // Isso não compila
	}
	
}

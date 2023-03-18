package com.topics.typepromotion;

// 
// https://www.geeksforgeeks.org/automatic-type-promotion-in-overloading-in-java/
/*
 * What is Automatic Type Promotion?
 * The name Type Promotion specifies that a small size datatype can be
 * promoted to a large size datatype. i.e.,
 * an Integer data type can be promoted to long, float, double, etc.
 * This Automatic Type Promotion is done when any method which accepts
 * a higher size data type argument is called with the smaller data type.
 */
/*
 * Basicamente sempre converte o valor de tipo de menor tamanho,  
 * para um tipo de maior tamanho, por ex: de int para float, de float para double.
 * Nunca ao contrário.
 */
public class TypePromotion {
	
	public static void main(String[] args) {
		double a = promoteToDouble(2);
		double b = promoteToDouble('a');
		
		System.out.println(a);
		System.out.println(b); // Converte de char, diretamente para double (int de char vem da tabela unicode, no caso, a = 97, por isso o double = 97.0

		// Erro: promoteError(2.02);
		// Pois não é possível converter um valor de tipo de maior tamanho, para um de menor tamanho, no caso, de double, para int.
	}
	
	public static double promoteToDouble(double a) {
		System.out.println("Automatic Type Promoted to double- " + a);
		return a;
	}
	
	public static void promoteError(int a) {
		System.out.println("Automatic Type Promoted to double- " + a);
	}
	
}

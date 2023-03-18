package com.topics.wrapperclasses;

public class WrapperClasses {

	// Consiste no converão automática de tipos primitivos e abstratos, e conceitos de autoboxing e unboxing, como abaixo:
	public static void main(String[] args) {
		int a = 10;
		
		Integer b = Integer.valueOf(a); // Conversão explícita 
		Integer c = a; // Autoboxing, conversão automática

		
		Integer d = new Integer(3);
		int e = d.intValue(); // Conversão explícita
		int f = d; // Unboxing, conversão automática
		
		
		// Custom wrapper:
		int Z = new CustomWrapper(Integer.valueOf(1)).getValue();
	}

}

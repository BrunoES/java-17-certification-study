package com.topics.wrapperclasses;

public class WrapperClasses {

	// Consiste no conver�o autom�tica de tipos primitivos e abstratos, e conceitos de autoboxing e unboxing, como abaixo:
	public static void main(String[] args) {
		int a = 10;
		
		Integer b = Integer.valueOf(a); // Convers�o expl�cita 
		Integer c = a; // Autoboxing, convers�o autom�tica

		
		Integer d = new Integer(3);
		int e = d.intValue(); // Convers�o expl�cita
		int f = d; // Unboxing, convers�o autom�tica
		
		
		// Custom wrapper:
		int Z = new CustomWrapper(Integer.valueOf(1)).getValue();
	}

}

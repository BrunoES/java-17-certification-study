package com.java17.certification.overview.tests;

public class B extends A {

	static {
		if (false) throw new RuntimeException();
	}
	
	public static void main(String[] args) {
		test();
	}
	
	static void test() {
		var a = false;
		
		if (a = true ) {
			System.out.println("Entrei");
		}
	}
}

package com.java17.certification.overview.tests;

public class Tests {

	static Double d;
	
	public static void main(String[] args) {
		int balance = 1999;
		int interest = 10;
		int years = 5;
		
		int comp = balance * ((1 + interest / 100) * years -1 );
		
		int x = 3;
		int y = ++x * 4 / x-- + --x;
		
		System.out.println(x);
		System.out.println(y);
		
		
		int _5 = 10;
		int z = _5;
		
		System.out.println(_5 / z);
		
		
	}
}

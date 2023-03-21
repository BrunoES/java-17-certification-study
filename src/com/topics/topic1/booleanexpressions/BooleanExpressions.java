package com.topics.topic1.booleanexpressions;

public class BooleanExpressions {
	
	public static void main (String[] args) {
		int age = 18;
		boolean isAdult = age >= 18; // boolean expression
		
		System.out.println(isAdult);
		
		if(isAdult) {
			System.out.println("He is an adult");
		}
		
		while(isAdult) {
			System.out.println("He has bills to pay");
			break;
		}
	}
	
}

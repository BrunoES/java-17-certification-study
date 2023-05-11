package com.topics.topic2.controlprogrammingflow;

public class IfEOperadores {

	public static void main(String[] args) {
		
		// Possui circuit braker, ou seja, quando a condição satisfaz, já abandona o If.
		if(retornaTrue() || retornaFalse()) {
			System.out.println(true);
		}
		
		// Sempre executa os dois lados da condição.
		if(retornaTrue() | retornaFalse()) {
			System.out.println(true);
		}
		
		// Possui circuit braker, ou seja, quando a condição satisfaz, já abandona o If.
		if(retornaFalse() && retornaTrue()) {
			System.out.println(true);
		}
		
		// Sempre executa os dois lados da condição.
		if(retornaFalse() & retornaTrue()) {
			System.out.println(true);
		}
		
		// Ou Exclusivo
		if(true ^ false) {
			System.out.println("XOR");
		}
		
		// Ou Exclusivo
		if(true ^ true) {
			System.out.println("XOR");
		}
		
	}
	
	public static boolean retornaTrue() {
		System.out.println("retornaTrue");
		return true;
	}
	
	public static boolean retornaFalse() {
		System.out.println("retornaFalse");
		return false;
	}

}

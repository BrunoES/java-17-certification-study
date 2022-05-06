package com.java09.certification.trywithresources;

public class TryWithResources {

	public static void main(String [] args) throws Exception {
		// Java 8
		try(Recurso1 r1 = new Recurso1();
			Recurso2 r2 = new Recurso2()) {
			System.out.println("Fazendo try;");
		}
		
		// Java 9
		Recurso1 r1 = new Recurso1();
		Recurso2 r2 = new Recurso2();
		try(r1;r2) {
			System.out.println("Fazendo try;");
		}
	}
	
	static class Recurso1 implements AutoCloseable {
		@Override
		public void close() throws Exception{
			System.out.println("Recurso 1 close");
		}
	}
	
	static class Recurso2 implements AutoCloseable {
		@Override
		public void close() throws Exception{
			System.out.println("Recurso 2 close");
		}
	}
	
}

package com.java15.certification.overview;

public class Java15 {

	public static void main(String[] args) {
		// Sealed Classes: Ver classes do pactoe.

		// Sealed Classes com Pattern Matching em vez de instanceof
		Car car = new Car();
		Truck truck = new Truck();
		
		Veiculo v = new Car();
		/* Ver se continua fazendo sentido nas pr�ximas vers�es.
		switch(car) {
			case Veiculo -> System.out.println("� um Ve�culo");
			default -> System.out.println("");
		}
		*/
		
	}

}

package com.java14.certification.overview;

public class Java14 {

	public static void main(String[] args) {
		
		// Nova forma de utiliza��o do instance of
		String teste = "";
		// boolean a = ((teste instanceof String abc) && abc.equals(teste));
		
	
		// Records:
		RecordPerson person = new RecordPerson("Bruno", "Rua x.");
		System.out.println(person.name());
		System.out.println(person.address());
		System.out.println(person.equals(null));
		System.out.println(person.hashCode());
		System.out.println(person.toString());
		
		RecordPerson person2 = new RecordPerson("Bruno H.");
		System.out.println(person2.name());
		
		// Records tamb�m podem possui atributos staticos, assim como as classes
	}

}

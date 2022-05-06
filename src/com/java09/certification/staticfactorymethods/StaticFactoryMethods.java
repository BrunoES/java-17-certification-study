package com.java09.certification.staticfactorymethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StaticFactoryMethods {

	public static void main(String[] args) {
		Optional<Integer> empty = Optional.empty();
		// Ex: .empty() é um StaticFactoryMethod
		
		List<Object> list = new ArrayList<Object>();
		List<Object> novaLista = Collections.unmodifiableList(list);
		// novaLista.add(""); // Dará erro
		
	}

}

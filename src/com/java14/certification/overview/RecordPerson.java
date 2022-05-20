package com.java14.certification.overview;

import java.util.Objects;

public record RecordPerson(String name, String address) {
	
	public RecordPerson {
		Objects.requireNonNull(name);
		Objects.requireNonNull(address);
	}
	
	public RecordPerson(String name) {
		this(name, "teste"); // alternativa ao this.name = name;
	}
	
}

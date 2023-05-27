package com.topics.topic6.streams;

public class Person {
	private PersonType type;
	private String name;
	private int age;
	
	public Person(String name, int age, PersonType type) {
		super();
		this.type = type;
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public PersonType getType() {
		return type;
	}

	public void setType(PersonType type) {
		this.type = type;
	}
	
}

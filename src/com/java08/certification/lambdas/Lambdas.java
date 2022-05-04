package com.java08.certification.lambdas;

import java.util.Arrays;
import java.util.List;

public class Lambdas {

	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Olá Mundo");
			}
		}).run();;
		
		// Lambda
		new Thread(() -> System.out.println("Olá Mundo")).run();
		
		List<Integer> list = Arrays.asList(1,2,3,4);
		
		
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(0) > 0) {
				System.out.println(list.get(i));
			}
		}
		
		// Stream
		list.stream()
		.filter(e -> e > 0)
		.forEach(e -> System.out.println(e));
	}

}

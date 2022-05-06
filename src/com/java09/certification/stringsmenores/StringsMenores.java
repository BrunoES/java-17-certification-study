package com.java09.certification.stringsmenores;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.stream.Collectors;

public class StringsMenores {

	public static void main(String[] args) throws InterruptedException {
		Instant inicio = Instant.now();
		
		Thread.sleep(10000);
		
		new Random().ints()
		.limit(10_000_000)
		.boxed()
		.map(x -> x.toString())
		.collect(Collectors.joining());
		
		Thread.sleep(5000);
		Instant fim = Instant.now();
		System.out.println(Duration.between(inicio, fim));
	}

}

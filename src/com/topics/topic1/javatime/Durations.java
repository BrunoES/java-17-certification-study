package com.topics.topic1.javatime;

import java.time.Duration;
import java.time.LocalTime;

public class Durations {

	// A Duration measures an amount of time using time-based values (seconds, nanoseconds).
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duration ofDays = Duration.ofDays(1);
		System.out.println(ofDays);
		
		Duration ofHours = Duration.ofHours(2);
		System.out.println(ofHours);
		
		Duration ofMinutes = Duration.ofMinutes(120);
		System.out.println(ofMinutes);
		
		Duration ofSeconds = Duration.ofSeconds(60);
		System.out.println(ofSeconds);
		
		Duration ofSeconds2 = Duration.ofSeconds(180);
		System.out.println(ofSeconds2);
	
		Duration ofSeconds3 = Duration.ofSeconds(180, 5000);
		System.out.println(ofSeconds3);
		
		LocalTime lt1 = LocalTime.now().minusHours(1);
		LocalTime lt2 = LocalTime.now();
		// Obs: Duration não calcula between entre dois LocalDate, apenas entre LocalTimes, ou LocalDateTimes.
		Duration between = Duration.between(lt1, lt2);
		System.out.println(between);
		
		// Parse:
		System.out.println("Parse: ");
		System.out.println(Duration.parse("PT3M"));
	}

}

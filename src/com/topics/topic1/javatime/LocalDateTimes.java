package com.topics.topic1.javatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate now = LocalDate.now();
		LocalTime timeNow = LocalTime.now();

		// of
		LocalDateTime.of(now, timeNow);
		System.out.println(LocalDateTime.of(1990, Month.AUGUST, 25, 15, 10, 5, 1));
		// ou 
		System.out.println(LocalDateTime.of(LocalDate.of(1990, Month.AUGUST, 25), LocalTime.of(15, 10, 5, 1)));	
	}

}

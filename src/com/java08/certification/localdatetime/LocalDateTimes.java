package com.java08.certification.localdatetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimes {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(now);
		// of
		System.out.println(LocalDate.of(1990, Month.AUGUST, 25));
		// plus
		now.plusDays(1);
		now.plusMonths(1);
		now.plusWeeks(1);
		now.plusYears(1);
		now.minusDays(1);
		now.minusMonths(1);
		now.minusWeeks(1);
		now.minusYears(1);
		// N�o atualiza o valor
		
		LocalTime timeNow = LocalTime.now();
		System.out.println(timeNow);
		// of
		System.out.println(LocalTime.of(15, 10, 5, 1));
		
		LocalDateTime localDateTimeNow = LocalDateTime.now();
		System.out.println(localDateTimeNow);
		// of
		LocalDateTime.of(now, timeNow);
		System.out.println(LocalDateTime.of(1990, Month.AUGUST, 25, 15, 10, 5, 1));
		// ou 
		System.out.println(LocalDateTime.of(LocalDate.of(1990, Month.AUGUST, 25), LocalTime.of(15, 10, 5, 1)));
		
		
		Instant instantNow = Instant.now();
		System.out.println(instantNow);
		// of
		System.out.println(Instant.ofEpochMilli(50000L));
		// plus
		// Ir� falhar, pois apenas dias s�o suportados pelo Instant
		// Ex: instantNow.plus(1, ChronoUnit.MONTHS);
		
		ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
		System.out.println(zonedDateTimeNow);
		// of
		ZonedDateTime.of(localDateTimeNow, ZoneId.of("America/Montevideo"));
	}
}

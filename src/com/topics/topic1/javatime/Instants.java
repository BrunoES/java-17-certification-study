package com.topics.topic1.javatime;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/*
 * Representa um momento na linha do tempo, literalmente um contador de nanosegundos.
 */
public class Instants {

	public static void main(String[] args) {
		factoryMethods();
		plusMinus();
		get();
		atZone();
		until();
		atOffset();
		isAfterOfBefore();
	}
	
	/*
	 * M�todos de factory do Instant.
	 */
	public static void factoryMethods() {
		System.out.println("\n now");
		Instant now = Instant.now();
		System.out.println(now);
		
		System.out.println("\n nowClockUTC: ");
		Instant nowClockUTC = Instant.now(Clock.systemUTC());
		System.out.println(nowClockUTC);
		
		System.out.println("\n nowClockZonedIDDefault");
		Instant nowClockZonedIDDefault = Instant.now(Clock.system(ZoneId.systemDefault()));
		System.out.println(nowClockZonedIDDefault);
		
		System.out.println("\n nowClockZonedID");
		Instant nowClockZonedID = Instant.now(Clock.system(ZoneId.of("Asia/Tokyo")));
		System.out.println(nowClockZonedID);
		
		Long nowMillis = System.currentTimeMillis();
		
		System.out.println("\n ofEpochMilli");
		Instant fromMillis = Instant.ofEpochMilli(nowMillis);
		System.out.println(fromMillis);
		
		System.out.println("\n ofEpochSecond1");
		Long nowSeconds = nowMillis / 1000; 
		Instant fromSeconds = Instant.ofEpochSecond(nowSeconds);
		System.out.println(fromSeconds);
		
		System.out.println("\n ofEpochSecon2");
		Instant fromSeconds2 = Instant.ofEpochSecond(nowSeconds, 345000000); // Soma 345000000 millis ao tempo do Instant.
		System.out.println(fromSeconds2);
		
		System.out.println("\n parse");
		Instant parsed = Instant.parse("2023-04-02T15:00:00.345000000Z");
		System.out.println(parsed);
	}

	/*
	 * Adiciona ou diminui valores.
	 */
	public static void plusMinus() {
		System.out.println("\n plusMinus");
		
		Instant now = Instant.now();
		Duration durationOfHours = Duration.ofHours(2);
		Period periodOf1Day= Period.ofDays(1);
		
		System.out.println(now.minus(1L, ChronoUnit.SECONDS));
		System.out.println(now.minus(durationOfHours)); // Diminui duas horas.
		System.out.println(now.minusMillis(1000));
		System.out.println(now.minusSeconds(60));
		System.out.println(now.minusNanos(1000));
		
		System.out.println(now.plus(1L, ChronoUnit.SECONDS));
		System.out.println(now.plus(periodOf1Day)); // Aumenta 1 dia.
		System.out.println(now.plusMillis(1000));
		System.out.println(now.plusSeconds(60));
		System.out.println(now.plusNanos(1000));
		
	}
	
	/*
	 * Pega o valor a partir de um ChronoField.
	 */
	public static void get() {
		System.out.println("\n get");
		
		Instant now = Instant.now();
		
		System.out.println(now.get(ChronoField.MICRO_OF_SECOND));
		System.out.println(now.get(ChronoField.MILLI_OF_SECOND));
		System.out.println(now.get(ChronoField.NANO_OF_SECOND));
		System.out.println(now.getLong(ChronoField.INSTANT_SECONDS));
	}
	
	
	/*
	 * Convert the instant instance to an specific ZoneId.
	 */
	public static void atZone() {
		System.out.println("\n atZone");
		
		Instant now = Instant.now();
		
		System.out.println(now.atZone(ZoneId.systemDefault()));
	}
	
	/*
	 * Return the difference between two Instant, with a specific ChronoUnit.
	 */
	public static void until() {
		System.out.println("\n atZone");
		
		Instant now = Instant.now();
		Instant nowMais5 = Instant.now().plus(5L, ChronoUnit.HOURS);
		
		// 5 Horas de diferen�a
		System.out.println(now.until(nowMais5, ChronoUnit.HOURS));
	}
	
	/*
	 * Adiciona offset no hor�rio original
	 */
	public static void atOffset() {
		System.out.println("\n atZone");
		
		Instant now = Instant.now();
		
		// 5 Horas de diferen�a
		System.out.println(now);
		System.out.println(now.atOffset(ZoneOffset.UTC)); // Mant�m
		System.out.println(now.atOffset(ZoneOffset.ofHours(5))); // Adiciona 5 horas
		System.out.println(now.atOffset(ZoneOffset.MIN)); // Diminui 18 horas
		System.out.println(now.atOffset(ZoneOffset.MAX)); // Aumenta 18 horas
	}

	public static void isAfterOfBefore() {
		System.out.println("\n isAfterOfBefore");
		
		Instant now = Instant.now();
		Instant nowMais5 = Instant.now().plus(5L, ChronoUnit.HOURS);
		
		
		System.out.println(now.isAfter(nowMais5));
		System.out.println(now.isBefore(nowMais5));
	}

}

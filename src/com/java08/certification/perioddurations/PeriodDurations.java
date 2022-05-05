package com.java08.certification.perioddurations;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class PeriodDurations {

	public static void main(String[] args) {
		
		// PERIOD ******
		// Métodos de factory
		Period p = Period.of(1970, 4, 14);
		System.out.println(p);
		
		Period p2 = Period.of(1970, 0, 14);
		System.out.println(p2);
		
		Period p3 = Period.of(1970, 4, 0);
		System.out.println(p3);
		
		Period p4 = Period.of(1970, 0, 0);
		System.out.println(p4);
		
		Period p5= Period.of(0, 0, 0);
		System.out.println(p5);
		
		Period p6= Period.ofDays(1);
		System.out.println(p6);
		
		Period p7= Period.ofMonths(1);
		System.out.println(p7);
		
		Period p8= Period.ofWeeks(1);
		System.out.println(p8);
		
		Period p9= Period.ofYears(1);
		System.out.println(p9);
		
		// Intervalo entre Datas: 
		LocalDate l1 = LocalDate.now().minusDays(1);
		LocalDate l2 = LocalDate.now();
		Period p10= Period.between(l1, l2);
		Period p11= Period.between(l2, l1);
		System.out.println(p10);
		System.out.println(p11);
		
		p11 = p11.plusDays(1);
		System.out.println(p11);
		
		// Setar periodo diretamente:
		Period until = l1.until(l2);
		
		// É possível setar plus ou minus em um LocalDate com Period
		// Em um LocalTime isso não será possível
		l1.plus(p11);
		
		
		
		// DURATION ******
		// Métodos de factory
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
		// Obs: Duration não calcula between entre dois LocalDate, apenas entre LocalTimes
		Duration between = Duration.between(lt1, lt2);
		System.out.println(between);
		
		between = between.plusDays(1);
		between = between.plusMillis(1000);
	}

}

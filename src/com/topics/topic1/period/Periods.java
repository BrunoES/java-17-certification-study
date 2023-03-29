package com.topics.topic1.period;

import java.time.LocalDate;
import java.time.Period;

public class Periods {

	// A Period uses date-based values (years, months, days).
	public static void main(String[] args) {
		
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
		System.out.println("Invervalo entre datas: ");
		LocalDate l1 = LocalDate.now().minusDays(1);
		LocalDate l2 = LocalDate.now();
		Period p10= Period.between(l1, l2); // P1D
		Period p11= Period.between(l2, l1); // P-1D
		Period p12= Period.between(l2, l2); // P0D
		System.out.println(p10);
		System.out.println(p11);
		System.out.println(p12);
		
		// Parse:
		System.out.println(Period.parse("P1D"));
		System.out.println(Period.parse("P1970Y4M14D"));
		
		// From:
		// This method obtains an instance of Period from a temporal amount.
		
		// Setar Period com until do LocalDate
		Period until = l1.until(l2);
		System.out.println(until);
		
		until = l2.until(l1);
		System.out.println(until);
		
		until = l2.until(l2);
		System.out.println(until);
		
		// Setar periodo à um LocalDate
		l1.plus(p11);
		System.out.println(1);
	}

}

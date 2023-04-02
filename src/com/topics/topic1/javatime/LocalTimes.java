package com.topics.topic1.javatime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/*
 * https://www.javatpoint.com/java-localtime
 */
public class LocalTimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalTime timeNow = LocalTime.now();
		System.out.println(timeNow);
		
		format();
		parse();
		get();
		// Outros comportamentos iguais comuns LocalDate;
	}
	
	/*
	 * Of - Método de factory
	 */
	public static void of() {
		System.out.println("\nof:");
		
		/*
		 * @param hour  the hour-of-day to represent, from 0 to 23
		 * @param minute  the minute-of-hour to represent, from 0 to 59
		 * @param second  the second-of-minute to represent, from 0 to 59
		 * @param nanoOfSecond  the nano-of-second to represent, from 0 to 999,999,999
		 */
		System.out.println(LocalTime.of(15, 10, 5, 1));
	}
	
	/*
	 * Formata o time mediante um DateTimeFormatter
	 */
	public static void format() {
		System.out.println("\nformat:");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime t1 = LocalTime.now();
		String horaFormatada = t1.format(dtf);
		
		System.out.println(horaFormatada);
	}
	
	/*
	 * Faz o parse de data mediante String e/ou DateTimeFormatter.
	 */
	public static void parse() {
		System.out.println("\nparse:");
		
		LocalTime t1 = LocalTime.parse("15:00:00");
		LocalTime t2 = null;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		t2 = LocalTime.parse("15:00:00", dtf);
		
		System.out.println(t1);
		System.out.println(t2);
	}
	
	/*
	 * It is used to get the value of the specified field from this date as an int.
	 */
	public static void get() {
		System.out.println("\nget:");
		
		LocalTime t1 = LocalTime.now();
		
		System.out.println(t1.get(ChronoField.HOUR_OF_DAY));
		// System.out.println(d1.get(ChronoField.DAY_OF_YEAR)); // Unsupported field: DAY_OF_YEAR, não tem dia;
		System.out.println(t1.get(ChronoField.SECOND_OF_DAY));
		System.out.println(t1.get(ChronoField.SECOND_OF_MINUTE));
	}
	

}

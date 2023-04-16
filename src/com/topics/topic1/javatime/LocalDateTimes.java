package com.topics.topic1.javatime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/*
 * https://www.javatpoint.com/java-localdatetime
 */
public class LocalDateTimes {

	public static void main(String[] args) {
		of();
		format();
		parse();
		get();
		ofInstant();
		adjustInto();
		// Outros comportamentos iguais comuns LocalDate;
		// Métodos e atributos cumulativos do LocalDate + LocalTime 
	}
	
	/*
	 * Of - Método de factory
	 */
	public static void of() {
		System.out.println("\nof:");
		
		// TODO Auto-generated method stub
		LocalDate now = LocalDate.now();
		LocalTime timeNow = LocalTime.now();
		
		// of
		LocalDateTime.of(now, timeNow);
		/*
		 * @param year  the year to represent, from MIN_YEAR to MAX_YEAR
		 * @param month  the month-of-year to represent, not null
		 * @param dayOfMonth  the day-of-month to represent, from 1 to 31
		 * @param hour  the hour-of-day to represent, from 0 to 23
		 * @param minute  the minute-of-hour to represent, from 0 to 59
		 * @param second  the second-of-minute to represent, from 0 to 59
		 * @param nanoOfSecond  the nano-of-second to represent, from 0 to 999,999,999
		 */
		System.out.println(LocalDateTime.of(1990, Month.AUGUST, 25, 15, 10, 5, 1));
		// ou 
		// Passar um LocalDate, e um LocalTime
		System.out.println(LocalDateTime.of(LocalDate.of(1990, Month.AUGUST, 25), LocalTime.of(15, 10, 5, 1)));	
	}
	
	/*
	 * Formata o time mediante um DateTimeFormatter
	 */
	public static void format() {
		System.out.println("\nformat:");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dt1 = LocalDateTime.now();
		String horaFormatada = dt1.format(dtf);
		
		System.out.println(horaFormatada);
	}
	
	/*
	 * Faz o parse de data mediante String e/ou DateTimeFormatter.
	 */
	public static void parse() {
		System.out.println("\nparse:");
		
		LocalDateTime dt1 = LocalDateTime.parse("2023-02-04T15:00:00");
		//LocalDate.parse("04/02/2023 15:00:00"); Da erro de formato sem passar no padrão, e sem definir um DateTimeFormat
		LocalDateTime dt2 = null;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		dt2 = LocalDateTime.parse("02/04/2023 15:00:00", dtf);
		
		System.out.println(dt1);
		System.out.println(dt2);
	}
	
	/*
	 * It is used to get the value of the specified field from this date as an int.
	 */
	public static void get() {
		System.out.println("\nget:");
		
		LocalDateTime dt1 = LocalDateTime.now();
		
		System.out.println(dt1.get(ChronoField.DAY_OF_YEAR));
		System.out.println(dt1.get(ChronoField.ERA));
		System.out.println(dt1.get(ChronoField.YEAR_OF_ERA));
		System.out.println(dt1.get(ChronoField.HOUR_OF_DAY));
		System.out.println(dt1.get(ChronoField.SECOND_OF_DAY));
		System.out.println(dt1.get(ChronoField.SECOND_OF_MINUTE));
	}
	
	/*
	 * Create an LocalDateTime from a instant with a specific ZoneId.
	 */
	public static void ofInstant() {
		System.out.println("\nofInstant:");
		
		LocalDateTime dt1 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		System.out.println(dt1);
	}
	
	/*
	 * Ajusta um Temporal para utilizar o mesmo horário de outra instância.
	 */
	public static void adjustInto() {
		System.out.println("\nadjustInto:");
		
		ZonedDateTime zdtm = ZonedDateTime.now();
		LocalDateTime dt1 = LocalDateTime.now().plusHours(5L);
		
		System.out.println(zdtm);
		
		zdtm = (ZonedDateTime) dt1.adjustInto(zdtm);
		
		System.out.println(zdtm);
	}
	

}

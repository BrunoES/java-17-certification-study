package com.topics.topic1.javatime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

public class LocalDates {

	/*
	 * https://www.javatpoint.com/java-localdate
	 */
	public static void main(String[] args) {
		plus();
		format();
		constructors();
		parse();
		with();
		atTime();
		compareTo();
		get();
		isLeapYear();
		getDayOfYear();
		getMonthValue();
		lengthOfMonth();
		lengthOfYear();
		format();
	}
	
	/*
	 * Os métodos plus, sempre vão adicionar o valor correspondente, por exemplo:
	 * Considerando o valor de 12/05/2019, realizarndo plusMonths(1), o resultado seria 12/06/2019,
	 * não são adicionados 30 dias, mas sim o mês é incrementado.
	 */
	public static void plus() {
		System.out.println("\nplus:");
		
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
		

		// Não muda o valor:
		System.out.println(now);
		
		now = now.minusYears(1);
		// Muda o valor:
		System.out.println(now);
	}
	
	/*
	 * Formata a data mediante um DateTimeFormatter
	 */
	public static void format() {
		System.out.println("\nformat:");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d1 = LocalDate.now();
		String dataFormatada = d1.format(dtf);
		
		System.out.println(dataFormatada);
	}
	
	/*
	 * Faz o parse de data mediante String e/ou DateTimeFormatter.
	 */
	public static void parse() {
		System.out.println("\nparse:");
		
		LocalDate d1 = LocalDate.parse("2019-12-31");
		//LocalDate.parse("2019-1-1"); Não compila
		LocalDate d2 = null;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		d2 = LocalDate.parse("31/12/2019", dtf);
		
		System.out.println(d1);
		System.out.println(d2);
	}
	
	public static void constructors() {
		System.out.println("\nconstrutores:");
		
		// Válido:
	    LocalDate.of(2019,12,31);
	    LocalDate.ofYearDay(2019,110);
	    
	    // Inválido: Não compila
	    // LocalDate.of(2019, "JANUARY", 1);
	    // new LocalDate(2019, 1, 1);
	}
	
	/*
	 * Neste caso, o método with irá "arredondar" a data para o próximo Domingo mais próximo da data atual.
	 */
	public static void with() {
		System.out.println("\nwith:");
		
		LocalDate now = LocalDate.now();
		LocalDate nextSundy = now.with(DayOfWeek.SUNDAY);
		System.out.println(nextSundy);;
	}
	
	
	/*
	 * Tráz um LocalDateTime a partir dos parâmetros enviados.
	 */
	public static void atTime() {
		System.out.println("\natTime:");
		
		LocalDateTime localDateTime = LocalDate.now().atTime(1, 1);
		System.out.println(localDateTime);
	}
	
	/*
	 * Compara duas LocalDate.
	 */
	public static void compareTo() {
		System.out.println("\ncompareTo:");
		
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = LocalDate.now();
		
		// 0
		System.out.println(d1.compareTo(d2));

		// 5:
		d2 = d2.minusDays(5);
		System.out.println(d1.compareTo(d2));
		
		// -10:
		d1 = d1.minusDays(10);
		d2 = d2.plusDays(5);
		System.out.println(d1.compareTo(d2));
		
		// 10:
		System.out.println(d2.compareTo(d1));
	}
	
	/*
	 * It is used to get the value of the specified field from this date as an int.
	 */
	public static void get() {
		System.out.println("\nget:");
		
		LocalDate d1 = LocalDate.now();
		
		System.out.println(d1.get(ChronoField.DAY_OF_YEAR));
		// System.out.println(d1.get(ChronoField.CLOCK_HOUR_OF_AMPM)); // Unsupported field: ClockHourOfAmPm, não tem hora.s
		System.out.println(d1.get(ChronoField.ERA));
		System.out.println(d1.get(ChronoField.YEAR_OF_ERA));
	}
	
	/*
	 * It is used to check if the year is a leap year, according to the ISO proleptic calendar system rules.
	 * Leap Year = Ano Bissexto.
	 */
	public static void isLeapYear() {
		System.out.println("\nget:");
		
		System.out.println(LocalDate.now().isLeapYear());
	}
	
	/*
	 * Retorna o dia do ano com base em um inteiro sequencial;
	 */
	public static void getDayOfYear() {
		System.out.println("\ngetDayOfYear:");
		
		LocalDate d1 = LocalDate.now();
		System.out.println(d1.getDayOfYear());
	}
	
	/*
	 * Retorna o mês do ano de 1 - 12
	 */
	public static void getMonthValue() {
		System.out.println("\ngetMonthValue:");
		
		LocalDate d1 = LocalDate.now();
		System.out.println(d1.getMonthValue());
	}
	
	/*
	 * Retorna o comprimeito do mês em dia
	 */
	public static void lengthOfMonth() {
		System.out.println("\nlengthOfMonth:");
		
		LocalDate d1 = LocalDate.now();
		System.out.println(d1.lengthOfMonth());
	}
	
	/*
	 * Retorna comprimeto do ano em dias
	 */
	public static void lengthOfYear() {
		System.out.println("\nlengthOfYear:");
		
		LocalDate d1 = LocalDate.now();
		System.out.println(d1.lengthOfYear());
	}

}

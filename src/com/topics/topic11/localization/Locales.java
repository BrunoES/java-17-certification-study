package com.topics.topic11.localization;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Locales {

	// Referência:
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Lista de languages mantida por IANA: https://www.iana.org/assignments/language-subtag-registry/language-subtag-registry
		
		// Formas de construir um Locale:
		System.out.println("\n Formas de construir um Locale:");
		
		Locale loc = new Locale("PT");
		loc = new Locale("PT", "BR");
		loc = new Locale("PT", "BR", "BR");
		
		loc = Locale.JAPAN;
		loc = Locale.JAPANESE;
		
		loc = Locale.forLanguageTag("pt-BR");
		
		// Locale e seu atributos:
		System.out.println("\n Locale e seu atributos:");
		
		Locale locPT = new Locale("PT", "PT");
		
		System.out.println(locPT);
		System.out.println(locPT.getCountry());
		System.out.println(locPT.getDisplayName());
		System.out.println(locPT.getDisplayLanguage());
		System.out.println(locPT.getDisplayVariant());
		
		Locale locPT_BR = new Locale("PT", "BR", "BR");
		
		System.out.println(locPT_BR);
		System.out.println(locPT_BR.getCountry());
		System.out.println(locPT_BR.getDisplayName());
		System.out.println(locPT_BR.getDisplayLanguage());
		System.out.println(locPT_BR.getDisplayVariant());
		
		
		
		// Default Locale:
		System.out.println("\n Default Locale:");
		
		System.out.println(Locale.getDefault());
		
		Locale.setDefault(new Locale("en"));
		
		System.out.println(Locale.getDefault());
		
		
		// Recuperando Locales instalados na JDK:
		System.out.println("\n Recuperando Locales instalados na JDK:");
		
		Locale[] numberFormatLocales = NumberFormat.getAvailableLocales();
		Locale[] dateFormatLocales = DateFormat.getAvailableLocales();
		Locale[] locales = Locale.getAvailableLocales();
		
		// Formatando valores com Locales:
		System.out.println("\n Formatando valores com Locales:");
		
		Locale frLocale = Locale.FRANCE;
		Locale usLocale = Locale.US;
		Locale ukLocale = Locale.UK;
		
		double number = 104565.4565d;
		
		NumberFormat frNumberFormat = NumberFormat.getInstance(frLocale);
		NumberFormat usNumberFormat = NumberFormat.getInstance(usLocale);
		NumberFormat ukNumberFormat = NumberFormat.getInstance(ukLocale);
		
		String frFormattedDouble = frNumberFormat.format(number);
		String usFormattedDouble = usNumberFormat.format(number);
		String ukFormattedDouble = ukNumberFormat.format(number);
		
		System.out.println(frFormattedDouble);
		System.out.println(usFormattedDouble);
		System.out.println(ukFormattedDouble);
		
		// Formatando LocalDate, LocalTime, DateTime, e ZonedDatetTime:
		System.out.println("\n Formatando LocalDate, LocalTime, DateTime, e ZonedDatetTime:");
		
		LocalDateTime ldtm = LocalDateTime.now();
		String pattern = "dd-MMMM-yyyy HH:mm:ss.SSS";
		
		DateTimeFormatter defaulDateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
		DateTimeFormatter localizedDeteTimeFormatter = DateTimeFormatter.ofPattern(pattern, Locale.JAPAN);
		
		String defaultFormat = defaulDateTimeFormatter.format(ldtm);
		String localizedFormat = localizedDeteTimeFormatter.format(ldtm);
		
		System.out.println(defaultFormat);
		System.out.println(localizedFormat);
		
		// Formatando LocalizedDateTime:
		System.out.println("\n Formatando LocalizedDateTime:");
		
		LocalDateTime localizedLdtm = LocalDateTime.now();
		ZoneId zoneIdSaoPaulo = TimeZone.getTimeZone("America/Sao_Paulo").toZoneId();
		
		DateTimeFormatter localizedTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		String formattedLocalizedTime = localizedTimeFormatter.format(ZonedDateTime.of(localizedLdtm, zoneIdSaoPaulo));
		System.out.println(formattedLocalizedTime);
		
		// Formatando DateFormat and SimpleDateFormatter
		System.out.println("\n Formatando DateFormat and SimpleDateFormatter");
		
		Date date = new Date();
		
		// getDateTimeInstance || getDateInstance || getTimeInstance
		DateFormat formatJpInstance = DateFormat.getDateTimeInstance(
				DateFormat.FULL, DateFormat.FULL, Locale.JAPAN);
		
		DateFormat formatFrInstance = DateFormat.getDateTimeInstance(
				DateFormat.FULL, DateFormat.FULL, Locale.FRANCE);
		
		String jpDateFormatted = formatJpInstance.format(date);
		String frDateFormatted = formatFrInstance.format(date);
		
		System.out.println(jpDateFormatted);
		System.out.println(frDateFormatted);
	}

}

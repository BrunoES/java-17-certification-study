package com.topics.topic1.javatime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.TimeZone;

public class TimeZones {

	public static void main(String[] args) {
		
		// TimeZone:
		
		System.out.println(List.of(TimeZone.getAvailableIDs()));
		
		System.out.println(ZoneId.getAvailableZoneIds());
		
		System.out.println(TimeZone.getDefault());
		
		System.out.println(TimeZone.getTimeZone("America/Sao_Paulo"));
		
		System.out.println(TimeZone.getTimeZone(ZoneId.of("America/Sao_Paulo")));
		
		System.out.println(TimeZone.getTimeZone(ZoneId.systemDefault()));
		
		
		// ZonedDateTime:
		
		System.out.println(ZonedDateTime.now());
		
		System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Tokyo")));
		
		System.out.println(ZonedDateTime.of(2023, 4, 15, 14, 57, 05, 1, ZoneId.of("America/Havana")));
		
		System.out.println(ZonedDateTime.parse("2023-04-15T14:59:38.472468100-03:00[America/Sao_Paulo]"));
		
		// Cria ZonedDateTime a partir de LocalDateTime
		LocalDateTime dateTime = LocalDateTime.now();
		ZonedDateTime zdtm = dateTime.atZone(ZoneId.of("Asia/Tokyo"));
		System.out.println(zdtm);
		
		// Converte horário de um TZ para outro.
		ZonedDateTime zdtmTokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		ZonedDateTime zdtmSaoPaulo = zdtmTokyo.withZoneSameLocal(ZoneId.of("America/Sao_Paulo"));
		System.out.println(zdtmSaoPaulo);
		
		// Convert para LocalDateTime
		ZonedDateTime zdtmX = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		System.out.println(zdtmX.toLocalDate());
		System.out.println(zdtmX.toLocalTime());
		System.out.println(zdtmX.toLocalDateTime());
	}

}

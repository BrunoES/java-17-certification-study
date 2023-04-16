package com.topics.topic1.javatime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class TimeZones {

	public static void main(String[] args) {
		
		// TimeZone ZonedDateTime ================================================ :
		
		// Lista de TimeZones
		System.out.println(List.of(TimeZone.getAvailableIDs()));
		
		// Lista de ZoneIds
		System.out.println(ZoneId.getAvailableZoneIds());
		
		// TimeZone padrão
		System.out.println(TimeZone.getDefault());
		
		// Descrição por extenso
		System.out.println(TimeZone.getDefault().getDisplayName());
	
		// Retorna se esse timezone utiliza horário de verão
		System.out.println(TimeZone.getDefault().useDaylightTime());
		
		// Valida se uma data está em horário de verão
		System.out.println(TimeZone.getDefault().inDaylightTime(new Date()));
		
		// Retorna offset (ou diferença para o UTC padrão) deste timezone
		System.out.println(TimeZone.getDefault().getOffset(0));
		
		// Retorna offset (ou diferença para o UTC) deste timezone a partir de uma data, caso tenha daylight (horário de verão), por exemplo.
		System.out.println(TimeZone.getDefault().getOffset(new Date().getTime()));
		
		// TimeZone a partir de uma String de um ZoneId
		System.out.println(TimeZone.getTimeZone("America/Sao_Paulo"));

		// TimeZone a partir de um ZoneId
		System.out.println(TimeZone.getTimeZone(ZoneId.of("America/Sao_Paulo")));
		
		// TimeZone a partir do ZoneId padrão
		System.out.println(TimeZone.getTimeZone(ZoneId.systemDefault()));
		
		
		// ZonedDateTime ================================================ :
		
		// Cria novo ZonedDateTime a partir do TimeZone padrão
		System.out.println(ZonedDateTime.now());
		
		// Cria novo ZonedDateTime a partir de um ZoneId
		System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Tokyo")));
		
		// Cria a partir de todos os dados
		System.out.println(ZonedDateTime.of(2023, 4, 15, 14, 57, 05, 1, ZoneId.of("America/Havana")));
		
		// Parse a partir de uma String
		System.out.println(ZonedDateTime.parse("2023-04-15T14:59:38.472468100-03:00[America/Sao_Paulo]"));
		
		// Cria ZonedDateTime a partir de LocalDateTime
		LocalDateTime dateTime = LocalDateTime.now();
		ZonedDateTime zdtm = dateTime.atZone(ZoneId.of("Asia/Tokyo"));
		System.out.println(zdtm);
		
		// Converte horário de um TZ para outro.
		ZonedDateTime zdtmTokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		ZonedDateTime zdtmSaoPaulo = zdtmTokyo.withZoneSameLocal(ZoneId.of("America/Sao_Paulo")); // Converte mantendo LocalDateTime
		 zdtmSaoPaulo = zdtmTokyo.withZoneSameInstant(ZoneId.of("America/Sao_Paulo")); // Converte mantendo Instant
		System.out.println(zdtmSaoPaulo);
		
		// Convert para LocalDateTime
		ZonedDateTime zdtmX = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		System.out.println(zdtmX.toLocalDate());
		System.out.println(zdtmX.toLocalTime());
		System.out.println(zdtmX.toLocalDateTime());
	}

}

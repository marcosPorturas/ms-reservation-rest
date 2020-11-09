package com.pe.web.reservation.app.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilitario {

	public static String convertToStringDate(LocalDateTime date) {

		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd-MM-yyyy HH:mm:ss");
		return  date.format(formatter);
	}
}

package br.com.devdojo.treinamento.springboot.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {
	
	public String formatLocalDateTimeDatabaseStyle(LocalDateTime data) {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(data);
	}

}

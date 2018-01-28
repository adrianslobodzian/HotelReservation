package com.github.adrianslobodzian.controllers;

import java.time.LocalDate;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class DateConverter implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(String source) {
		LocalDate date = LocalDate.parse(source);
		return date;
	}

}

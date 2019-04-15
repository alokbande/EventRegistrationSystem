package com.event;

import java.text.ParseException;

import org.hibernate.HibernateException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author M1021173
 *
 */
@ControllerAdvice
public class ErrorHandlingController {

	@ExceptionHandler
	public String handleHibernateException(HibernateException e) {
		return "error";
	}

	@ExceptionHandler
	public String handleParseException(ParseException e) {
		return "error";
	}

	@ExceptionHandler
	public String handleException(Exception e) {
		return "error";
	}
}

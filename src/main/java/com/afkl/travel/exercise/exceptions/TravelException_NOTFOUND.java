package com.afkl.travel.exercise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Resource not found")
public class TravelException_NOTFOUND extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3386053117905133041L;
}
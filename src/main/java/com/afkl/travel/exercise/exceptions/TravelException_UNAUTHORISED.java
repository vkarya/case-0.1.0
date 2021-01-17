package com.afkl.travel.exercise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Un-Authorised Request")
public class TravelException_UNAUTHORISED extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8846913909677655290L;

}
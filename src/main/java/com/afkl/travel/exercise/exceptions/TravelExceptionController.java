package com.afkl.travel.exercise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TravelExceptionController {
	
	@ExceptionHandler(value=TravelException_UNAUTHORISED.class)
	public ResponseEntity<Object[]> exception(TravelException_UNAUTHORISED ex){
		return new ResponseEntity("Un-Authorised Access", HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(value=TravelException_NOTFOUND.class)
	public ResponseEntity<Object[]> exception(TravelException_NOTFOUND ex){
		return new ResponseEntity("Resource not found", HttpStatus.NOT_FOUND);
	}	
}

package com.creditcard.validator.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CardExceptionHandler extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(InvalidCardNumberException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public CreditCardErrorResponse handleNoRecordFoundException(InvalidCardNumberException ex) {

		CreditCardErrorResponse errorResponse = new CreditCardErrorResponse("Invalid Card Number Provided", HttpStatus.BAD_REQUEST);
	    return errorResponse;
	}

}

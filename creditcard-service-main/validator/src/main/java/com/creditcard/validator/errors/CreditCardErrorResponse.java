package com.creditcard.validator.errors;

import org.springframework.http.HttpStatus;

public class CreditCardErrorResponse {

	private String message;
	private HttpStatus status;

	public CreditCardErrorResponse(String defaultMessage, HttpStatus status) {
		this.message = defaultMessage;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
    
    
}

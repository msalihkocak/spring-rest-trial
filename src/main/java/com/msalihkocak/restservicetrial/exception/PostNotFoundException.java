package com.msalihkocak.restservicetrial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1231333132354847L;

	public PostNotFoundException(String message) {
		super(message);
		
		
	}
	
}

package com.msalihkocak.restservicetrial.helloworld;

public class HelloWorld {
	private Long identifier;
	private String message;
	
	public HelloWorld(Long identifier, String message) {
		super();
		this.identifier = identifier;
		this.message = message;
	}
	public Long getIdentifier() {
		return identifier;
	}
	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

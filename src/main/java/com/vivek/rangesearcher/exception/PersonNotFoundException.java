package com.vivek.rangesearcher.exception;

public class PersonNotFoundException extends RuntimeException {

	private String id;
	
	public PersonNotFoundException(String id) {
		this.id=id;
	}
	
	public String getId() {return id;}
	
}

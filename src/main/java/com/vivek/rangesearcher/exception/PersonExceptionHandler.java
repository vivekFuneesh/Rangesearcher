package com.vivek.rangesearcher.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public PersonError validationFailed(MethodArgumentNotValidException manve) {
		
		List<String> errors = manve.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
		PersonError me=new PersonError(400,errors.toString());
		return me;
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public PersonError notFoundErrors(PersonNotFoundException unf) {
		return new PersonError(404, "Person with ID "+unf.getId()+" Not Found");
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public PersonError otherExceptions(Exception ex) {
		return new PersonError(400,	ex.getMessage());
	}
	
}

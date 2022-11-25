package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class Exception extends RuntimeException {

	private static final long serialVersionUID = 1L;
private String resourceNmae;
private String fieldname;
private Object fieldValue;
public Exception(String resourceNmae, String fieldname, Object fieldValue) {
	super();
	this.resourceNmae = resourceNmae;
	this.fieldname = fieldname;
	this.fieldValue = fieldValue;
}

public String getResourceNmae() {
	return resourceNmae;
}
public String getFieldname() {
	return fieldname;
}
public Object getFieldValue() {
	return fieldValue;
}
}

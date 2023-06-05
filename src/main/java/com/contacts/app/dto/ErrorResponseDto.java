package com.contacts.app.dto;

import java.util.Date;
import java.util.List;

public class ErrorResponseDto {

	private Date timestamp;
	private String message;
	
	private List<String> errors;
	
	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorResponseDto(Date timestamp, String message, List<String> errors) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errors = errors;
	}
	
}

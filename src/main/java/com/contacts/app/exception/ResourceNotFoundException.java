package com.contacts.app.exception;

import java.util.function.Supplier;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String msg){
		super(msg);
	}

}

package com.resort.spring_resort_application.exception;

@SuppressWarnings("serial")
public class AddressIdNotFound extends RuntimeException {
	private String message="address id is not found in the DB";

	public String getMessage() {
		return message;
	}

}

package com.resort.spring_resort_application.exception;

@SuppressWarnings("serial")
public class CustomerIdNotFound extends RuntimeException {
	private String message="customer id is not found in the DB";

	public String getMessage() {
		return message;
	}
}

package com.resort.spring_resort_application.exception;

@SuppressWarnings("serial")
public class ResortIdNotFound extends RuntimeException {
	private String message="resort id is not found in the DB";

	public String getMessage() {
		return message;
	}

}

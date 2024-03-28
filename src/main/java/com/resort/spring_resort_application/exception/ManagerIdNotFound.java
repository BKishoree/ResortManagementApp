package com.resort.spring_resort_application.exception;

@SuppressWarnings("serial")
public class ManagerIdNotFound extends RuntimeException {

	private String message="manager id is not found in the DB";

	public String getMessage() {
		return message;
	}
}

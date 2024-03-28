package com.resort.spring_resort_application.exception;

@SuppressWarnings("serial")
public class EmployeeIdNotFound extends RuntimeException {

	private String message="employee id is not found in the DB";

	public String getMessage() {
		return message;
	}
}

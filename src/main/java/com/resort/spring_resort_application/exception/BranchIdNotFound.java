package com.resort.spring_resort_application.exception;

@SuppressWarnings("serial")
public class BranchIdNotFound extends RuntimeException {
	private String message="branch id is not found in the DB";

	public String getMessage() {
		return message;
	}
}

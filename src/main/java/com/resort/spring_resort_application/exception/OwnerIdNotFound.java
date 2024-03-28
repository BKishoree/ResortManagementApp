package com.resort.spring_resort_application.exception;

@SuppressWarnings("serial")
public class OwnerIdNotFound extends RuntimeException{

	private String message="owner id is not found in the DB";

	public String getMessage() {
		return message;
	}
}

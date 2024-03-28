package com.resort.spring_resort_application.exception;

@SuppressWarnings("serial")
public class FoodIdNotFound extends RuntimeException {

	private String message="food id is not found in the DB";

	public String getMessage() {
		return message;
	}
}

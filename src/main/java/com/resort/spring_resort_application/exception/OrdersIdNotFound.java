package com.resort.spring_resort_application.exception;

@SuppressWarnings("serial")
public class OrdersIdNotFound extends RuntimeException {
	private String message="order id is not found in the DB";

	public String getMessage() {
		return message;
	}

}

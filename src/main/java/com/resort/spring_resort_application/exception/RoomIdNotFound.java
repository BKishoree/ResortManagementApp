package com.resort.spring_resort_application.exception;

@SuppressWarnings("serial")
public class RoomIdNotFound extends RuntimeException {
	private String message="room id is not found in the DB";

	public String getMessage() {
		return message;
	}

}

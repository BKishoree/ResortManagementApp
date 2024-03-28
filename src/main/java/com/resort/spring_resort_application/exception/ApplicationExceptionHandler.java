package com.resort.spring_resort_application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.resort.spring_resort_application.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(ownerIdNotFound.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResortIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> resortIdNotFound(ResortIdNotFound resortIdNotFound) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(resortIdNotFound.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RoomIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> roomIdNotFound(RoomIdNotFound roomIdNotFound) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(roomIdNotFound.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(OrdersIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ordersIdNotFound(OrdersIdNotFound ordersIdNotFound) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(ordersIdNotFound.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> managerIdNotFound(ManagerIdNotFound managerIdNotFound) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(managerIdNotFound.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FoodIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>>foodIdNotFound(FoodIdNotFound foodIdNotFound) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(foodIdNotFound.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> employeeIdNotFound(EmployeeIdNotFound employeeIdNotFound) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(employeeIdNotFound.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> customerIdNotFound(CustomerIdNotFound customerIdNotFound ) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(customerIdNotFound.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>>branchIdNotFound(BranchIdNotFound branchIdNotFound ) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(branchIdNotFound.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>>addressIdNotFound(AddressIdNotFound addressIdNotFound ) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(addressIdNotFound.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

}

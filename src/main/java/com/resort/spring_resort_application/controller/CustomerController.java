package com.resort.spring_resort_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resort.spring_resort_application.dto.Customer;
import com.resort.spring_resort_application.dto.Orders;
import com.resort.spring_resort_application.dto.Room;
import com.resort.spring_resort_application.service.CustomerService;
import com.resort.spring_resort_application.util.ResponseStructure;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@GetMapping("/fetchCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(@RequestParam int customerId) {
		return customerService.fetchCustomerById(customerId);
	}

	@DeleteMapping("/deleteCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@RequestParam int customerId) {
		return customerService.deleteCustomerById(customerId);
	}

	@PutMapping("/updateCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomerById(@RequestParam int oldCustomerId, @RequestBody Customer newCustomer) {
		return customerService.updateCustomerById(oldCustomerId, newCustomer);
	}

	@PutMapping("/addExistingRoomToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addExistingRoomToExistingCustomer(@RequestParam int oldCustomerId, @RequestParam int oldRoomId) {
		return customerService.addExistingRoomToExistingCustomer(oldCustomerId, oldRoomId);
	}

	@PutMapping("/addNewRoomToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addNewRoomToExistingCustomer(@RequestParam int oldCustomerId, @RequestBody Room newRoom) {
		return customerService.addNewRoomToExistingCustomer(oldCustomerId, newRoom);

	}

	@PutMapping("/addExistingOrdersToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addExistingOrdersToExistingCustomer(@RequestParam int customerId, @RequestParam int orderId) {
		return customerService.addExistingOrdersToExistingCustomer(customerId, orderId);
	}

	@PutMapping("/addNewOrdersToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addNewOrdersToExistingCustomer(@RequestParam int customerId, @RequestBody Orders newOrder) {
		return customerService.addNewOrdersToExistingCustomer(customerId, newOrder);
	}
}

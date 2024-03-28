package com.resort.spring_resort_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.resort.spring_resort_application.dao.CustomerDao;
import com.resort.spring_resort_application.dto.Customer;
import com.resort.spring_resort_application.dto.Orders;
import com.resort.spring_resort_application.dto.Room;
import com.resort.spring_resort_application.exception.CustomerIdNotFound;
import com.resort.spring_resort_application.util.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully created into DB");
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if(customer!=null)
		{
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched into DB");
		responseStructure.setData(customerDao.fetchCustomerById(customerId));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if(customer!=null)
		{
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted into DB");
		responseStructure.setData(customerDao.deleteCustomerById(customerId));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		}else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomerById(int oldCustomerId, Customer newCustomer) {
		Customer customer = customerDao.fetchCustomerById(oldCustomerId);
		if(customer!=null)
		{
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(customerDao.updateCustomerById(oldCustomerId, newCustomer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		}else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> addExistingRoomToExistingCustomer(int oldCustomerId,
			int oldRoomId) {
		Customer customer = customerDao.fetchCustomerById(oldCustomerId);
		if(customer!=null)
		{
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(customerDao.addExistingRoomToExistingCustomer(oldCustomerId, oldRoomId));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		}else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> addNewRoomToExistingCustomer(int oldCustomerId, Room newRoom) {
		Customer customer = customerDao.fetchCustomerById(oldCustomerId);
		if(customer!=null)
		{
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(customerDao.addNewRoomToExistingCustomer(oldCustomerId, newRoom));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		}else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> addExistingOrdersToExistingCustomer(int customerId,
			int orderId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if(customer!=null)
		{
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(customerDao.addExistingOrdersToExistingCustomer(customerId, orderId));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		}else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> addNewOrdersToExistingCustomer(int customerId, Orders newOrder) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if(customer!=null)
		{
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(customerDao.addNewOrdersToExistingCustomer(customerId, newOrder));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		}else {
			throw new CustomerIdNotFound();
		}
	}
}

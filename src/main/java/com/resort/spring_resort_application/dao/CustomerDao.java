package com.resort.spring_resort_application.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.resort.spring_resort_application.dto.Customer;
import com.resort.spring_resort_application.dto.Orders;
import com.resort.spring_resort_application.dto.Room;
import com.resort.spring_resort_application.repo.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	RoomDao roomDao;

	@Autowired
	OrdersDao ordersDao;

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer fetchCustomerById(int customerId) {
		return customerRepo.findById(customerId).get();
	}

	public Customer deleteCustomerById(int customerId) {
		Customer customer = customerRepo.findById(customerId).get();
		customerRepo.delete(customer);
		return customer;
	}

	public Customer updateCustomerById(int oldCustomerId, Customer newCustomer) {
		newCustomer.setCustomerId(oldCustomerId);
		return customerRepo.save(newCustomer);
	}

	public Customer addExistingRoomToExistingCustomer(int oldCustomerId, int oldRoomId) {
		Customer customer = fetchCustomerById(oldCustomerId);
		Room room = roomDao.fetchRoomById(oldRoomId);

		customer.setRoom(room);
		return saveCustomer(customer);
	}

	public Customer addNewRoomToExistingCustomer(int oldCustomerId, Room newRoom) {
		Customer dbCustomer = fetchCustomerById(oldCustomerId);
		roomDao.saveRoom(newRoom);
		dbCustomer.setRoom(newRoom);
		return saveCustomer(dbCustomer);

	}

	public Customer addExistingOrdersToExistingCustomer(int customerId, int orderId) {
		Customer customer = fetchCustomerById(customerId);
		Orders orders = ordersDao.fetchOrderById(orderId);

		customer.getOrders().add(orders);
		return saveCustomer(customer);
	}

	public Customer addNewOrdersToExistingCustomer(int customerId, Orders newOrder) {
		Customer customer = fetchCustomerById(customerId);
		ordersDao.saveOrder(newOrder);
		customer.getOrders().add(newOrder);
		return saveCustomer(customer);

	}
}

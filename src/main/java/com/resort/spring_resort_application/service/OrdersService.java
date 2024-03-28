package com.resort.spring_resort_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.resort.spring_resort_application.dao.OrdersDao;
import com.resort.spring_resort_application.dto.Food;
import com.resort.spring_resort_application.dto.Orders;
import com.resort.spring_resort_application.exception.OrdersIdNotFound;
import com.resort.spring_resort_application.util.ResponseStructure;

@Service
public class OrdersService {

	@Autowired
	OrdersDao ordersDao;

	public ResponseEntity<ResponseStructure<Orders>> saveOrder(Orders order) {
		ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully created into DB");
		responseStructure.setData(ordersDao.saveOrder(order));
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Orders>> fetchOrderById(int orderId) {
		Orders orders = ordersDao.fetchOrderById(orderId);
		if(orders!=null)
		{
		ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched into DB");
		responseStructure.setData(ordersDao.fetchOrderById(orderId));
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.FOUND);
		}
		else {
			throw new OrdersIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Orders>> deleteOrderById(int orderId) {
		Orders orders = ordersDao.fetchOrderById(orderId);
		if(orders!=null)
		{
		ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted into DB");
		responseStructure.setData(ordersDao.deleteOrderById(orderId));
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.OK);
		}else {
			throw new OrdersIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Orders>> updateOrderById(int oldOrderId, Orders newOrder) {
		Orders orders = ordersDao.fetchOrderById(oldOrderId);
		if(orders!=null)
		{
		ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(ordersDao.updateOrderById(oldOrderId, newOrder));
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.OK);
		}else {
			throw new OrdersIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Orders>> addExistingFoodToExistingOrders(int orderId, int foodId) {
		Orders orders = ordersDao.fetchOrderById(orderId);
		if(orders!=null)
		{
		ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(ordersDao.addExistingFoodToExistingOrders(orderId, foodId));
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.OK);
		}else {
			throw new OrdersIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Orders>> addNewFoodToExistingOrders(int orderId, Food newFood) {
		Orders orders = ordersDao.fetchOrderById(orderId);
		if(orders!=null)
		{
		ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(ordersDao.addNewFoodToExistingOrders(orderId, newFood));
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.OK);
		}else {
			throw new OrdersIdNotFound();
		}
	}
}

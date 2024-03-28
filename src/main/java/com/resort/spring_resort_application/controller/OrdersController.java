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

import com.resort.spring_resort_application.dto.Food;
import com.resort.spring_resort_application.dto.Orders;
import com.resort.spring_resort_application.service.OrdersService;
import com.resort.spring_resort_application.util.ResponseStructure;

@RestController
public class OrdersController {

	@Autowired
	OrdersService ordersService;

	@PostMapping("/saveOrder")
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(@RequestBody Orders order) {
		return ordersService.saveOrder(order);
	}

	@GetMapping("/fetchOrderById")
	public ResponseEntity<ResponseStructure<Orders>> fetchOrderById(@RequestParam int orderId) {
		return ordersService.fetchOrderById(orderId);
	}

	@DeleteMapping("/deleteOrderById")
	public ResponseEntity<ResponseStructure<Orders>> deleteOrderById(@RequestParam int orderId) {
		return ordersService.deleteOrderById(orderId);
	}

	@PutMapping("/updateOrderById")
	public ResponseEntity<ResponseStructure<Orders>> updateOrderById(@RequestParam int oldOrderId, @RequestBody Orders newOrder) {
		return ordersService.updateOrderById(oldOrderId, newOrder);
	}

	@PutMapping("/addExistingFoodToExistingOrders")
	public ResponseEntity<ResponseStructure<Orders>> addExistingFoodToExistingOrders(@RequestParam int orderId, @RequestParam int foodId) {
		return ordersService.addExistingFoodToExistingOrders(orderId, foodId);
	}

	@PutMapping("/addNewFoodToExistingOrders")
	public ResponseEntity<ResponseStructure<Orders>> addNewFoodToExistingOrders(@RequestParam int orderId, @RequestBody Food newFood) {
		return ordersService.addNewFoodToExistingOrders(orderId, newFood);
	}
}

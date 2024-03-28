package com.resort.spring_resort_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.resort.spring_resort_application.dto.Food;
import com.resort.spring_resort_application.dto.Orders;

import com.resort.spring_resort_application.repo.OrdersRepo;

@Repository
public class OrdersDao {

	@Autowired
	OrdersRepo ordersRepo;

	@Autowired
	FoodDao foodDao;

	public Orders saveOrder(Orders order) {
		return ordersRepo.save(order);
	}

	public Orders fetchOrderById(int orderId) {
		Optional<Orders> order = ordersRepo.findById(orderId);
		if(order.isPresent())
		{
			return order.get();
		}return null;
	}

	public Orders deleteOrderById(int orderId) {
		Orders order = ordersRepo.findById(orderId).get();
		ordersRepo.delete(order);
		return order;
	}

	public Orders updateOrderById(int oldOrderId, Orders newOrder) {
		newOrder.setOrderId(oldOrderId);
		return ordersRepo.save(newOrder);
	}

	public Orders addExistingFoodToExistingOrders(int orderId, int foodId) {
		Orders order = fetchOrderById(orderId);
		Food food = foodDao.fetchFoodById(orderId);
		order.getFoods().add(food);
		return saveOrder(order);
	}

	public Orders addNewFoodToExistingOrders(int orderId, Food newFood) {
		Orders order = fetchOrderById(orderId);
		foodDao.saveFood(newFood);
		order.getFoods().add(newFood);
		return saveOrder(order);
	}
}

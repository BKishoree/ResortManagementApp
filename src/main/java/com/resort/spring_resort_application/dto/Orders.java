package com.resort.spring_resort_application.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private int orderNumber;
	private int orderQuantity;
	private double orderGst;
	private double orderDiscount;

	@OneToMany
	private List<Food> foods;

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public double getOrderGst() {
		return orderGst;
	}

	public void setOrderGst(double orderGst) {
		this.orderGst = orderGst;
	}

	public double getOrderDiscount() {
		return orderDiscount;
	}

	public void setOrderDiscount(double orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

}

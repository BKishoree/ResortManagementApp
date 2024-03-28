package com.resort.spring_resort_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.resort.spring_resort_application.dao.FoodDao;
import com.resort.spring_resort_application.dto.Food;
import com.resort.spring_resort_application.exception.FoodIdNotFound;
import com.resort.spring_resort_application.util.ResponseStructure;

@Service
public class FoodService {

	@Autowired
	FoodDao foodDao;

	public ResponseEntity<ResponseStructure<Food>> saveFood(Food food) {
		ResponseStructure<Food> responseStructure = new ResponseStructure<Food>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully created into DB");
		responseStructure.setData(foodDao.saveFood(food));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Food>> fetchFoodById(int foodId) {
		Food food = foodDao.fetchFoodById(foodId);
		if(food!=null)
		{
		ResponseStructure<Food> responseStructure = new ResponseStructure<Food>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched into DB");
		responseStructure.setData(foodDao.fetchFoodById(foodId));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new FoodIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Food>> deleteFoodById(int foodId) {
		Food food = foodDao.fetchFoodById(foodId);
		if(food!=null)
		{
		ResponseStructure<Food> responseStructure = new ResponseStructure<Food>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted into DB");
		responseStructure.setData(foodDao.deleteFoodById(foodId));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
		}else {
			throw new FoodIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Food>> updateFoodById(int oldFoodId, Food newFood) {
		Food food = foodDao.fetchFoodById(oldFoodId);
		if(food!=null)
		{
		ResponseStructure<Food> responseStructure = new ResponseStructure<Food>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(foodDao.updateFoodById(oldFoodId, newFood));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
		}else {
			throw new FoodIdNotFound();
		}
	}
}

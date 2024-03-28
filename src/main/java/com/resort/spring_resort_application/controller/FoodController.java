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
import com.resort.spring_resort_application.service.FoodService;
import com.resort.spring_resort_application.util.ResponseStructure;

@RestController
public class FoodController {

	@Autowired
	FoodService foodService;
	
	@PostMapping("/saveFood")
	public ResponseEntity<ResponseStructure<Food>> saveFood(@RequestBody Food food)
	{
		return foodService.saveFood(food);
	}
	
	@GetMapping("/fetchFoodById")
	public ResponseEntity<ResponseStructure<Food>> fetchFoodById(@RequestParam int foodId)
	{
		return foodService.fetchFoodById(foodId);
	}
	
	@DeleteMapping("/deleteFoodById")
	public ResponseEntity<ResponseStructure<Food>> deleteFoodById(@RequestParam int foodId)
	{
		return foodService.deleteFoodById(foodId);
	}
	
	@PutMapping("/updateFoodById")
	public ResponseEntity<ResponseStructure<Food>> updateFoodById(@RequestParam int oldFoodId,@RequestBody Food newFood)
	{
		return foodService.updateFoodById(oldFoodId, newFood);
	}
}

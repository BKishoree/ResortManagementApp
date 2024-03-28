package com.resort.spring_resort_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.resort.spring_resort_application.dto.Food;
import com.resort.spring_resort_application.repo.FoodRepo;

@Repository
public class FoodDao {

	@Autowired
	FoodRepo foodRepo;
	
	public Food saveFood(Food food)
	{
		return foodRepo.save(food);
	}
	
	public Food fetchFoodById(int foodId)
	{
		Optional<Food> food = foodRepo.findById(foodId);
		if(food.isPresent())
		{
		return food.get();
		}return null;
	}
	
	public Food deleteFoodById(int foodId)
	{
		Food food = foodRepo.findById(foodId).get();
		foodRepo.delete(food);
		return food;
	}
	
	public Food updateFoodById(int oldFoodId,Food newFood)
	{
		newFood.setFoodId(oldFoodId);
		return foodRepo.save(newFood);
	}
}

package com.resort.spring_resort_application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resort.spring_resort_application.dto.Food;

public interface FoodRepo extends JpaRepository<Food, Integer> {

}

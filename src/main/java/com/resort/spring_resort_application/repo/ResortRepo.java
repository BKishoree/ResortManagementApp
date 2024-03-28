package com.resort.spring_resort_application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resort.spring_resort_application.dto.Resort;

public interface ResortRepo extends JpaRepository<Resort, Integer> {

}

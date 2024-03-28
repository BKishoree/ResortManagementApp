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

import com.resort.spring_resort_application.dto.Manager;
import com.resort.spring_resort_application.service.ManagerService;
import com.resort.spring_resort_application.util.ResponseStructure;

@RestController
public class ManagerController {

	@Autowired
	ManagerService managerService;
	
	@PostMapping("/saveManager")
	public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager)
	{
		return managerService.saveManager(manager);
	}
	
	@GetMapping("/fetchManagerById")
	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(@RequestParam int managerId)
	{
		return managerService.fetchManagerById(managerId);
	}
	
	@DeleteMapping("/deleteManagerById")
	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(@RequestParam int managerId)
	{
		return managerService.deleteManagerById(managerId);
	}
	
	@PutMapping("/updateManagerById")
	public ResponseEntity<ResponseStructure<Manager>> updateManagerById(@RequestParam int oldManagerId,@RequestBody Manager newManager)
	{
		return managerService.updateManagerById(oldManagerId, newManager);
	}
}

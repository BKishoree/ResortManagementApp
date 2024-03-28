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

import com.resort.spring_resort_application.dto.Owner;
import com.resort.spring_resort_application.dto.Resort;
import com.resort.spring_resort_application.service.OwnerService;
import com.resort.spring_resort_application.util.ResponseStructure;

@RestController
public class OwnerController {

	@Autowired
	OwnerService ownerService;
	
	@PostMapping("/saveOwner")
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner)
	{
		return ownerService.saveOwner(owner);
	}
	
	@GetMapping("/fetchOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(@RequestParam int ownerId)
	{
		return ownerService.fetchOwnerById(ownerId);
	}
	
	@DeleteMapping("/deleteOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(@RequestParam int ownerId)
	{
		return ownerService.deleteOwnerById(ownerId);
	}
	
	@PutMapping("/updateOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(@RequestParam int oldOwnerId,@RequestBody Owner newOwner)
	{
		return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}
	
	@PutMapping("/addExistingResortToExistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addExistingResortToExistingOwner(@RequestParam int ownerId,@RequestParam int resortId)
	{
		return ownerService.addExistingResortToExistingOwner(ownerId, resortId);
	}
	
	@PutMapping("/addNewResortToExistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addNewResortToExistingOwner(@RequestParam int ownerId,@RequestBody Resort newResort)
	{
		return ownerService.addNewResortToExistingOwner(ownerId, newResort);
	}
}

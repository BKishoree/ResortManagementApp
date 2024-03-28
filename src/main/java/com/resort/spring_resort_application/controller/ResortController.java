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

import com.resort.spring_resort_application.dto.Branch;
import com.resort.spring_resort_application.dto.Resort;
import com.resort.spring_resort_application.service.ResortService;
import com.resort.spring_resort_application.util.ResponseStructure;

@RestController
public class ResortController {

	@Autowired
	ResortService resortService;
	
	@PostMapping("/saveResort")
	public ResponseEntity<ResponseStructure<Resort>> saveResort(@RequestBody Resort resort)
	{
		return resortService.saveResort(resort);
	}
	
	@GetMapping("/fetchResortById")
	public ResponseEntity<ResponseStructure<Resort>> fetchResortById(@RequestParam int resortId)
	{
		return resortService.fetchResortById(resortId);
	}
	
	@DeleteMapping("/deleteResortById")
	public ResponseEntity<ResponseStructure<Resort>> deleteResortById(@RequestParam int resortId)
	{
		return resortService.deleteResortById(resortId);
	}
	
	@PutMapping("/updateResortById")
	public ResponseEntity<ResponseStructure<Resort>> updateResortById(@RequestParam int oldResortId,@RequestBody Resort newResort)
	{
		return resortService.updateResortById(oldResortId, newResort);
	}
	
	@PutMapping("/addExistingBranchToExistingResort")
	public ResponseEntity<ResponseStructure<Resort>> addExistingBranchToExistingResort(@RequestParam int resortId,@RequestParam int branchId)
	{
		return resortService.addExistingBranchToExistingResort(resortId, branchId);
	}
	
	@PutMapping("/addNewBranchToExistingResort")
	public ResponseEntity<ResponseStructure<Resort>> addNewBranchToExistingResort(@RequestParam int resortId,@RequestBody Branch newBranch)
	{
		return resortService.addNewBranchToExistingResort(resortId, newBranch);
	}
}

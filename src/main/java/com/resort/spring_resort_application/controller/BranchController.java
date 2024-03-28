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

import com.resort.spring_resort_application.dto.Address;
import com.resort.spring_resort_application.dto.Branch;
import com.resort.spring_resort_application.dto.Customer;
import com.resort.spring_resort_application.dto.Employee;
import com.resort.spring_resort_application.dto.Manager;
import com.resort.spring_resort_application.service.BranchService;
import com.resort.spring_resort_application.util.ResponseStructure;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}

	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);
	}

	@PutMapping("/updateBranchById")
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(@RequestParam int oldBranchId, @RequestBody Branch newBranch) {
		return branchService.updateBranchById(oldBranchId, newBranch);
	}

	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(@RequestParam int oldBranchId, @RequestParam int oldAddressId) {
		return branchService.addExistingAddressToExistingBranch(oldBranchId, oldAddressId);
	}

	@PutMapping("/addNewAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(@RequestParam int oldBranchId, @RequestBody Address newAddress) {
		return branchService.addNewAddressToExistingBranch(oldBranchId, newAddress);
	}

	@PutMapping("/addExistingManagerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingManagerToExistingBranch(@RequestParam int oldBranchId, @RequestParam int oldManagerId) {

		return branchService.addExistingManagerToExistingBranch(oldBranchId, oldManagerId);
	}

	@PutMapping("/addNewManagerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewManagerToExistingBranch(@RequestParam int oldBranchId, @RequestBody Manager newManager) {
		return branchService.addNewManagerToExistingBranch(oldBranchId, newManager);
	}

	@PutMapping("/addExistingEmployeeToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingEmployeeToExistingBranch(@RequestParam int branchId, @RequestParam int employeeId) {
		return branchService.addExistingEmployeeToExistingBranch(branchId, employeeId);
	}

	@PutMapping("/addNewEmployeeToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(@RequestParam int branchId, @RequestBody Employee newEmployee) {
		return branchService.addNewEmployeeToExistingBranch(branchId, newEmployee);
	}

	@PutMapping("/addExistingCustomerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingCustomerToExistingBranch(@RequestParam int branchId, @RequestParam int customerId) {
		return branchService.addExistingCustomerToExistingBranch(branchId, customerId);
	}

	@PutMapping("/addNewCustomerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewCustomerToExistingBranch(@RequestParam int branchId, @RequestBody Customer newCustomer) {
		return branchService.addNewCustomerToExistingBranch(branchId, newCustomer);
	}
}

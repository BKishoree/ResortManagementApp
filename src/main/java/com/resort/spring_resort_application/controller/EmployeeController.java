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

import com.resort.spring_resort_application.dto.Employee;
import com.resort.spring_resort_application.service.EmployeeService;
import com.resort.spring_resort_application.util.ResponseStructure;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/fetchEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(@RequestParam int employeeId)
	{
		return employeeService.fetchEmployeeById(employeeId);
	}
	
	@DeleteMapping("/deleteEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(@RequestParam int employeeId)
	{
		return employeeService.deleteEmployeeById(employeeId);
	}
	
	@PutMapping("/updateEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(@RequestParam int oldEmployeeId,@RequestBody Employee newEmployee)
	{
		return employeeService.updateEmployeeById(oldEmployeeId, newEmployee);
	}
}

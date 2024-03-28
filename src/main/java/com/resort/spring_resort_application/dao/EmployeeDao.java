package com.resort.spring_resort_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.resort.spring_resort_application.dto.Employee;

import com.resort.spring_resort_application.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee fetchEmployeeById(int employeeId) {
		Optional<Employee> employee = employeeRepo.findById(employeeId);
		if (employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	public Employee deleteEmployeeById(int employeeId) {
		Employee employee = employeeRepo.findById(employeeId).get();
		employeeRepo.delete(employee);
		return employee;
	}

	public Employee updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		newEmployee.setEmployeeId(oldEmployeeId);
		return employeeRepo.save(newEmployee);
	}

}

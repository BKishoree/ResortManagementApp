package com.resort.spring_resort_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.resort.spring_resort_application.dao.EmployeeDao;
import com.resort.spring_resort_application.dto.Employee;
import com.resort.spring_resort_application.exception.EmployeeIdNotFound;
import com.resort.spring_resort_application.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully created into DB");
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully fetched into DB");
			responseStructure.setData(employeeDao.fetchEmployeeById(employeeId));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully deleted into DB");
			responseStructure.setData(employeeDao.deleteEmployeeById(employeeId));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		Employee employee = employeeDao.fetchEmployeeById(oldEmployeeId);
		if (employee != null) {
			ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated into DB");
			responseStructure.setData(employeeDao.updateEmployeeById(oldEmployeeId, newEmployee));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

}

package com.resort.spring_resort_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.resort.spring_resort_application.dto.Address;
import com.resort.spring_resort_application.dto.Branch;
import com.resort.spring_resort_application.dto.Customer;
import com.resort.spring_resort_application.dto.Employee;
import com.resort.spring_resort_application.dto.Manager;
import com.resort.spring_resort_application.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;

	@Autowired
	AddressDao addressDao;

	@Autowired
	ManagerDao managerDao;

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	CustomerDao customerDao;

	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch fetchBranchById(int branchId) {
		Optional<Branch> branch = branchRepo.findById(branchId);
		if(branch.isPresent())
		{
		return branch.get();
		}return null;
	}

	public Branch deleteBranchById(int branchId) {
		Branch branch = branchRepo.findById(branchId).get();
		branchRepo.delete(branch);
		return branch;
	}

	public Branch updateBranchById(int oldBranchId, Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
		return branchRepo.save(newBranch);
	}

	public Branch addExistingAddressToExistingBranch(int oldBranchId, int oldAddressId) {
		Branch branch = fetchBranchById(oldBranchId);
		Address address = addressDao.fetchAddressById(oldAddressId);

		branch.setAddress(address);
		return saveBranch(branch);
	}

	public Branch addNewAddressToExistingBranch(int oldBranchId, Address newAddress) {
		Branch dbBranch = fetchBranchById(oldBranchId);
		addressDao.saveAddress(newAddress);
		dbBranch.setAddress(newAddress);
		return saveBranch(dbBranch);

	}

	public Branch addExistingManagerToExistingBranch(int oldBranchId, int oldManagerId) {
		Branch branch = fetchBranchById(oldBranchId);
		Manager manager = managerDao.fetchManagerById(oldManagerId);

		branch.setManager(manager);
		return saveBranch(branch);
	}

	public Branch addNewManagerToExistingBranch(int oldBranchId, Manager newManager) {
		Branch dbBranch = fetchBranchById(oldBranchId);
		managerDao.saveManager(newManager);
		dbBranch.setManager(newManager);
		return saveBranch(dbBranch);

	}

	public Branch addExistingEmployeeToExistingBranch(int branchId, int employeeId) {
		Branch branch = fetchBranchById(branchId);
		Employee employee = employeeDao.fetchEmployeeById(employeeId);

		branch.getEmployees().add(employee);
		return saveBranch(branch);

	}

	public Branch addNewEmployeeToExistingBranch(int branchId, Employee newEmployee) {
		Branch branch = fetchBranchById(branchId);
		employeeDao.saveEmployee(newEmployee);
		branch.getEmployees().add(newEmployee);
		return saveBranch(branch);

	}

	public Branch addExistingCustomerToExistingBranch(int branchId, int customerId) {
		Branch branch = fetchBranchById(branchId);
		Customer customer = customerDao.fetchCustomerById(customerId);

		branch.getCustomers().add(customer);
		return saveBranch(branch);

	}

	public Branch addNewCustomerToExistingBranch(int branchId, Customer newCustomer) {
		Branch branch = fetchBranchById(branchId);
		customerDao.saveCustomer(newCustomer);
		branch.getCustomers().add(newCustomer);
		return saveBranch(branch);

	}

}

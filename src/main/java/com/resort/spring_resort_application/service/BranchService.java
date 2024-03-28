package com.resort.spring_resort_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.resort.spring_resort_application.dao.BranchDao;
import com.resort.spring_resort_application.dto.Address;
import com.resort.spring_resort_application.dto.Branch;
import com.resort.spring_resort_application.dto.Customer;
import com.resort.spring_resort_application.dto.Employee;
import com.resort.spring_resort_application.dto.Manager;
import com.resort.spring_resort_application.exception.BranchIdNotFound;
import com.resort.spring_resort_application.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted into DB");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully fetched into DB");
			responseStructure.setData(branchDao.fetchBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully deleted into DB");
			responseStructure.setData(branchDao.deleteBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int oldBranchId, Branch newBranch) {
		Branch branch = branchDao.fetchBranchById(oldBranchId);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated into DB");
			responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int oldBranchId,
			int oldAddressId) {
		Branch branch = branchDao.fetchBranchById(oldBranchId);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated into DB");
			responseStructure.setData(branchDao.addExistingAddressToExistingBranch(oldBranchId, oldAddressId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(int oldBranchId,
			Address newAddress) {
		Branch branch = branchDao.fetchBranchById(oldBranchId);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated into DB");
			responseStructure.setData(branchDao.addNewAddressToExistingBranch(oldBranchId, newAddress));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingManagerToExistingBranch(int oldBranchId,
			int oldManagerId) {
		Branch branch = branchDao.fetchBranchById(oldBranchId);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated into DB");
			responseStructure.setData(branchDao.addExistingManagerToExistingBranch(oldBranchId, oldManagerId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewManagerToExistingBranch(int oldBranchId,
			Manager newManager) {
		Branch branch = branchDao.fetchBranchById(oldBranchId);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated into DB");
			responseStructure.setData(branchDao.addNewManagerToExistingBranch(oldBranchId, newManager));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingEmployeeToExistingBranch(int branchId, int employeeId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated into DB");
			responseStructure.setData(branchDao.addExistingEmployeeToExistingBranch(branchId, employeeId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(int branchId,
			Employee newEmployee) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated into DB");
			responseStructure.setData(branchDao.addNewEmployeeToExistingBranch(branchId, newEmployee));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingCustomerToExistingBranch(int branchId, int customerId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated into DB");
			responseStructure.setData(branchDao.addExistingCustomerToExistingBranch(branchId, customerId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewCustomerToExistingBranch(int branchId,
			Customer newCustomer) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated into DB");
			responseStructure.setData(branchDao.addNewCustomerToExistingBranch(branchId, newCustomer));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}
}

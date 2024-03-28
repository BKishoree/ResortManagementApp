package com.resort.spring_resort_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.resort.spring_resort_application.dao.ResortDao;
import com.resort.spring_resort_application.dto.Branch;
import com.resort.spring_resort_application.dto.Resort;
import com.resort.spring_resort_application.exception.ResortIdNotFound;
import com.resort.spring_resort_application.util.ResponseStructure;

@Service
public class ResortService {

	@Autowired
	ResortDao resortDao;

	public ResponseEntity<ResponseStructure<Resort>> saveResort(Resort resort) {
		ResponseStructure<Resort> responseStructure = new ResponseStructure<Resort>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully created into DB");
		responseStructure.setData(resortDao.saveResort(resort));
		return new ResponseEntity<ResponseStructure<Resort>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Resort>> fetchResortById(int resortId) {
		Resort resort = resortDao.fetchResortById(resortId);
		if(resort!=null)
		{
			ResponseStructure<Resort> responseStructure = new ResponseStructure<Resort>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully fetched into DB");
			responseStructure.setData(resortDao.fetchResortById(resortId));
			return new ResponseEntity<ResponseStructure<Resort>>(responseStructure, HttpStatus.FOUND);
		}
		else {
			throw new ResortIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Resort>> deleteResortById(int resortId) {
		Resort resort = resortDao.fetchResortById(resortId);
		if(resort!=null)
		{
		ResponseStructure<Resort> responseStructure = new ResponseStructure<Resort>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted into DB");
		responseStructure.setData(resortDao.deleteResortById(resortId));
		return new ResponseEntity<ResponseStructure<Resort>>(responseStructure, HttpStatus.OK);
		}
		else {
			throw new ResortIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Resort>> updateResortById(int oldResortId, Resort newResort) {
		Resort resort = resortDao.fetchResortById(oldResortId);
		if(resort!=null)
		{
		ResponseStructure<Resort> responseStructure = new ResponseStructure<Resort>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(resortDao.updateResortById(oldResortId, newResort));
		return new ResponseEntity<ResponseStructure<Resort>>(responseStructure, HttpStatus.OK);
		}
		else {
			throw new ResortIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Resort>> addExistingBranchToExistingResort(int resortId, int branchId) {
		Resort resort = resortDao.fetchResortById(resortId);
		if(resort!=null)
		{
		ResponseStructure<Resort> responseStructure = new ResponseStructure<Resort>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(resortDao.addExistingBranchToExistingResort(resortId, branchId));
		return new ResponseEntity<ResponseStructure<Resort>>(responseStructure, HttpStatus.OK);
		}
		else {
			throw new ResortIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Resort>> addNewBranchToExistingResort(int resortId, Branch newBranch) {
		Resort resort = resortDao.fetchResortById(resortId);
		if(resort!=null)
		{
		ResponseStructure<Resort> responseStructure = new ResponseStructure<Resort>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(resortDao.addNewBranchToExistingResort(resortId, newBranch));
		return new ResponseEntity<ResponseStructure<Resort>>(responseStructure, HttpStatus.OK);
		}
		else {
			throw new ResortIdNotFound();
		}
	}
}

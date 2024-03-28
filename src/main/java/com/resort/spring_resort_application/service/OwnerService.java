package com.resort.spring_resort_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.resort.spring_resort_application.dao.OwnerDao;
import com.resort.spring_resort_application.dto.Owner;
import com.resort.spring_resort_application.dto.Resort;
import com.resort.spring_resort_application.exception.OwnerIdNotFound;
import com.resort.spring_resort_application.util.ResponseStructure;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		ResponseStructure<Owner> responseStructure = new ResponseStructure<Owner>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully created into DB");
		responseStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			ResponseStructure<Owner> responseStructure = new ResponseStructure<Owner>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully fetched into DB");
			responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			ResponseStructure<Owner> responseStructure = new ResponseStructure<Owner>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully deleted into DB");
			responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}

	}

	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(int oldOwnerId, Owner newOwner) {
		Owner owner = ownerDao.fetchOwnerById(oldOwnerId);
		if (owner != null) {

			ResponseStructure<Owner> responseStructure = new ResponseStructure<Owner>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated into DB");
			responseStructure.setData(ownerDao.updateOwnerById(oldOwnerId, newOwner));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> addExistingResortToExistingOwner(int ownerId, int resortId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {

			ResponseStructure<Owner> responseStructure = new ResponseStructure<Owner>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated into DB");
			responseStructure.setData(ownerDao.addExistingResortToExistingOwner(ownerId, resortId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> addNewResortToExistingOwner(int ownerId, Resort newResort) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			ResponseStructure<Owner> responseStructure = new ResponseStructure<Owner>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated into DB");
			responseStructure.setData(ownerDao.addNewResortToExistingOwner(ownerId, newResort));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}
}

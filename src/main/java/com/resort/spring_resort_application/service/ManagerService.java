package com.resort.spring_resort_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.resort.spring_resort_application.dao.ManagerDao;
import com.resort.spring_resort_application.dto.Manager;
import com.resort.spring_resort_application.exception.ManagerIdNotFound;
import com.resort.spring_resort_application.util.ResponseStructure;

@Service
public class ManagerService {

	@Autowired
	ManagerDao managerDao;

	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager manager) {
		ResponseStructure<Manager> responseStructure = new ResponseStructure<Manager>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully created into DB");
		responseStructure.setData(managerDao.saveManager(manager));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(int managerId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		if(manager!=null)
		{
		ResponseStructure<Manager> responseStructure = new ResponseStructure<Manager>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched into DB");
		responseStructure.setData(managerDao.fetchManagerById(managerId));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(int managerId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		if(manager!=null)
		{
		ResponseStructure<Manager> responseStructure = new ResponseStructure<Manager>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted into DB");
		responseStructure.setData(managerDao.deleteManagerById(managerId));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		}else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Manager>> updateManagerById(int oldManagerId, Manager newManager) {
		Manager manager = managerDao.fetchManagerById(oldManagerId);
		if(manager!=null)
		{
		ResponseStructure<Manager> responseStructure = new ResponseStructure<Manager>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(managerDao.updateManagerById(oldManagerId, newManager));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		}else {
			throw new ManagerIdNotFound();
		}
	}

}

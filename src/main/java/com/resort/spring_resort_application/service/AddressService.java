package com.resort.spring_resort_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.resort.spring_resort_application.dao.AddressDao;
import com.resort.spring_resort_application.dto.Address;
import com.resort.spring_resort_application.exception.AddressIdNotFound;
import com.resort.spring_resort_application.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address)
	{
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted into DB");
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int addressId)
	{
		Address address = addressDao.fetchAddressById(addressId);
		if(address!=null)
		{
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched into DB");
		responseStructure.setData(addressDao.fetchAddressById(addressId));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new AddressIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId)
	{
		Address address = addressDao.fetchAddressById(addressId);
		if(address!=null)
		{
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted into DB");
		responseStructure.setData(addressDao.deleteAddressById(addressId));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		}else {
			throw new AddressIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddressById(int oldAddressId,Address newAddress)
	{
		Address address = addressDao.fetchAddressById(oldAddressId);
		if(address!=null)
		{
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		}else {
			throw new AddressIdNotFound();
		}
	}
}

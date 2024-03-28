package com.resort.spring_resort_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.resort.spring_resort_application.dto.Address;

import com.resort.spring_resort_application.repo.AddressRepo;

@Repository
public class AddressDao {
	
	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address)
	{
		return addressRepo.save(address);
	}
	
	public Address fetchAddressById(int addressId)
	{
		Optional<Address> address = addressRepo.findById(addressId);
		if(address.isPresent())
		{
		return address.get();
		}return null;
	}
	
	public Address deleteAddressById(int addressId)
	{
		Address address = addressRepo.findById(addressId).get();
		addressRepo.delete(address);
		return address;
	}
	
	public Address updateAddressById(int oldAddressId,Address newAddress)
	{
		newAddress.setAddressId(oldAddressId);
		return addressRepo.save(newAddress);
	}

}

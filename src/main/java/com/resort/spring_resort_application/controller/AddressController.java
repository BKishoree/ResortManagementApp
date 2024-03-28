package com.resort.spring_resort_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resort.spring_resort_application.dto.Address;
import com.resort.spring_resort_application.service.AddressService;
import com.resort.spring_resort_application.util.ResponseStructure;

@RestController
//@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address)
	{
		return addressService.saveAddress(address);
	}
	
	@GetMapping("/fetchAddressById")
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int addressId)
	{
		return addressService.fetchAddressById(addressId);
	}
	
	@DeleteMapping("/deleteAddressById")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId)
	{
		return addressService.deleteAddressById(addressId);
	}
	
	@PutMapping("/updateAddressById")
	public ResponseEntity<ResponseStructure<Address>> updateAddressById(@RequestParam int oldAddressId,@RequestBody Address newAddress)
	{
		return addressService.updateAddressById(oldAddressId, newAddress);
	}
}

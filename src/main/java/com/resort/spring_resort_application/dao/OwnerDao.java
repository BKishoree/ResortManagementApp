package com.resort.spring_resort_application.dao;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.resort.spring_resort_application.dto.Owner;
import com.resort.spring_resort_application.dto.Resort;
import com.resort.spring_resort_application.repo.OwnerRepo;

@Repository
public class OwnerDao {
	
	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	ResortDao resortDao;
	
	public Owner saveOwner(Owner owner)
	{
		return ownerRepo.save(owner);
	}
	
	public Owner fetchOwnerById(int ownerId)
	{
	 Optional<Owner> owner = ownerRepo.findById(ownerId);
	 if(owner.isPresent())
	 {
		 return owner.get();
	 }
	 return null;
		//return ownerRepo.findById(ownerId).get();
	}
	
	public Owner deleteOwnerById(int ownerId)
	{
		
		Owner owner = ownerRepo.findById(ownerId).get();
		ownerRepo.delete(owner);
		return owner;
	}
	
	public Owner updateOwnerById(int oldOwnerId,Owner newOwner)
	{
		newOwner.setOwnerId(oldOwnerId);
		return ownerRepo.save(newOwner);
	}
	
	public Owner addExistingResortToExistingOwner(int ownerId, int resortId)
	{
		Owner owner = fetchOwnerById(ownerId);
		Resort resort = resortDao.fetchResortById(resortId);
		
//		List<Resort> list = new ArrayList<Resort>();
//		list.add(resort);
//		owner.setResorts(list);
		
//		List<Resort> list = owner.getResorts();
//		list.add(resort);
//		owner.setResorts(list);
		
		owner.getResorts().add(resort);
		return saveOwner(owner);
		
	}
	
	public Owner addNewResortToExistingOwner(int ownerId, Resort newResort)
	{
		Owner owner = fetchOwnerById(ownerId);
		resortDao.saveResort(newResort);
		
//		List<Resort> list = new ArrayList<Resort>();
//		list.add(resort);
//		owner.setResorts(list);

//		List<Resort> list = owner.getResorts();
//		list.add(newResort);
//		owner.setResorts(list);
		
		owner.getResorts().add(newResort);
		return saveOwner(owner);
		
	}
}

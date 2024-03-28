package com.resort.spring_resort_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.resort.spring_resort_application.dto.Branch;
import com.resort.spring_resort_application.dto.Resort;
import com.resort.spring_resort_application.repo.ResortRepo;

@Repository
public class ResortDao {
	
	@Autowired
	ResortRepo resortRepo;
	
	@Autowired
	BranchDao branchDao;
	
	public Resort saveResort(Resort resort)
	{
		return resortRepo.save(resort);
	}
	
	public Resort fetchResortById(int resortId)
	{
		Optional<Resort> resort = resortRepo.findById(resortId);
		if(resort.isPresent())
		{
			return resort.get();
		}
		return null;
	}
	
	public Resort deleteResortById(int resortId)
	{
		Resort resort = resortRepo.findById(resortId).get();
		resortRepo.delete(resort);
		return resort;
	}
	
	public Resort updateResortById(int oldResortId,Resort newResort)
	{
		newResort.setResortId(oldResortId);
		return resortRepo.save(newResort);
	}

	public Resort addExistingBranchToExistingResort(int resortId, int branchId)
	{
		Resort resort = fetchResortById(resortId);
		Branch branch = branchDao.fetchBranchById(branchId);
		
		resort.getBranchs().add(branch);
		return saveResort(resort);
		
	}
	
	public Resort addNewBranchToExistingResort(int resortId, Branch newBranch)
	{
		Resort resort = fetchResortById(resortId);
		branchDao.saveBranch(newBranch);
		
		
		resort.getBranchs().add(newBranch);
		return saveResort(resort);
		
	}
}

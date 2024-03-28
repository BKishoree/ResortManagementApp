package com.resort.spring_resort_application.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;
	private String ownerName;
	private long ownerPhone;
	private double ownerNetWorth;
	private int ownerAge;
	
	@OneToMany
	List<Resort> resorts;
	
	
	public List<Resort> getResorts() {
		return resorts;
	}
	public void setResorts(List<Resort> resorts) {
		this.resorts = resorts;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(long ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public double getOwnerNetWorth() {
		return ownerNetWorth;
	}
	public void setOwnerNetWorth(double ownerNetWorth) {
		this.ownerNetWorth = ownerNetWorth;
	}
	public int getOwnerAge() {
		return ownerAge;
	}
	public void setOwnerAge(int ownerAge) {
		this.ownerAge = ownerAge;
	}
	
	

}

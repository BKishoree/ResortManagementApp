package com.resort.spring_resort_application.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Resort {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resortId;
	private String resortName;
	private String resortEmail;
	private long resortPhone;
	private double resortRating;
	
	@OneToMany
	List<Branch> branchs;
	
	
	
	public List<Branch> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}
	public int getResortId() {
		return resortId;
	}
	public void setResortId(int resortId) {
		this.resortId = resortId;
	}
	public String getResortName() {
		return resortName;
	}
	public void setResortName(String resortName) {
		this.resortName = resortName;
	}
	public String getResortEmail() {
		return resortEmail;
	}
	public void setResortEmail(String resortEmail) {
		this.resortEmail = resortEmail;
	}
	public long getResortPhone() {
		return resortPhone;
	}
	public void setResortPhone(long resortPhone) {
		this.resortPhone = resortPhone;
	}
	public double getResortRating() {
		return resortRating;
	}
	public void setResortRating(double resortRating) {
		this.resortRating = resortRating;
	}
	

}

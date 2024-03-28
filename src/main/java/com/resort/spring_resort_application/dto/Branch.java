package com.resort.spring_resort_application.dto;

import java.util.List;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	private String branchName;
	private String branchEmail;
	private long branchPhone;
	private double branchRating;
	
//	@OneToOne(cascade = CascadeType.ALL)
	@OneToOne
	private Address address;
	
	@OneToOne
	private Manager manager;
	
	@OneToMany
	private List<Employee> employees;
	
	@OneToMany
	private List<Customer> customers;
	
	
	
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchEmail() {
		return branchEmail;
	}
	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}
	public long getBranchPhone() {
		return branchPhone;
	}
	public void setBranchPhone(long branchPhone) {
		this.branchPhone = branchPhone;
	}
	public double getBranchRating() {
		return branchRating;
	}
	public void setBranchRating(double branchRating) {
		this.branchRating = branchRating;
	}
	
	

}

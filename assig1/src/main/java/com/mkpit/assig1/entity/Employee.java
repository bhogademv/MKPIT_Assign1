package com.mkpit.assig1.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dept;
    private java.util.Date doj;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Address>  addresses = new ArrayList<>();
    // Other fields and getters/setters
	public void setDoj(java.util.Date date) {
		this.doj = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public java.util.Date getDoj() {
		return doj;
	}
	public Employee(Long id, String name, String dept, Date doj, List<Address> addresses) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.doj = doj;
		this.addresses = addresses;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

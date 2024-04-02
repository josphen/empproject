package com.josphenmarya.empproject.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	
	
	@Column(unique=true, name="email_id")
	private String emailId;
	
	@Column(name="phone_number", length=10)
	private long phoneNumber;
    @JsonIgnoreProperties("employee")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Address> addresses;

	public Employee() {}

	public Employee(int id, String name, String emailId, long phoneNumber, List<Address> addresses) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.addresses = addresses;
	}
	
	public Employee(int id, String name, String emailId, long phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	
	
	
}

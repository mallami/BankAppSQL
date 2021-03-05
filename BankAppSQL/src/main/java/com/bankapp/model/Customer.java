package com.bankapp.model;

public class Customer {
	
	private int customerId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	
		
	public Customer() {
		super();
	}

	public Customer(int customerId, String username, String password, String firstName, String lastName, String phone) {
		this();
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}

	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
		
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + "]";
	}

}

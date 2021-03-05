package com.bankapp.dao;

import java.util.List;

import com.bankapp.model.Customer;

public interface CustomerDAO {
	
	public void createCustomer(Customer c);
	public Customer getCustomerById(Integer customerId);
	public Customer getCustomerByUsername(String username);
	public List<Customer> getAllCustomers();
	public void updateCustomer(Integer customerId, String firstName, String lastName, String phone);
	public void deleteCustomer(Integer customerId);

}

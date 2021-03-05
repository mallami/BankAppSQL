package com.bankapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bankapp.dao.*;
import com.bankapp.model.*;
import com.bankapp.service.*;

public class BankDAOImpl {
	
	static AccountDAOImpl aService;
	static CustomerDAOImpl cService;
	
	@BeforeClass
	public static void setUpToSetUp() {
		aService = new AccountDAOImpl();		
		cService = new CustomerDAOImpl();		
	}
	
	@Before
	public void setup() {
		aService = new AccountDAOImpl();		
		cService = new CustomerDAOImpl();		
	}
	
	@After
	public void reset() {
		aService = new AccountDAOImpl();		
		cService = new CustomerDAOImpl();		
	}
	
	@AfterClass
	public static void allDone() {
		aService = new AccountDAOImpl();		
		cService = new CustomerDAOImpl();		
	}
	
	@Test
	public void getAccountById() {
		aService.getAccountById(2201);
	}
	
	@Test
	public void getAllAccounts() {
		aService.getAllAccounts();
	}
	
	@Test
	public void getNotApprovedAccounts() {
		aService.getNotApprovedAccounts();
	}
	
	@Test
	public void dpositAmount() {
		aService.depositAmount(2201, 200.0);
	}
	
	@Test
	public void withdrawAmount() {
		aService.withdrawAmount(2201,  100.0);
	}
	
	@Test public void transferAmount( ) {
		aService.transferAmount(2201, 2202, 100.0);
	}
	
	@Test
	public void getCustomerById() {
		cService.getCustomerById(101);
	}
	
	@Test
	public void getCustomerByUsername( ) {
		cService.getCustomerByUsername("user1");
	}
	
	@Test
	public void getAllCustomers( ) {
		cService.getAllCustomers();
	}

}

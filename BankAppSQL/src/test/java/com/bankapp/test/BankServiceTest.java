package com.bankapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bankapp.model.*;
import com.bankapp.service.*;

public class BankServiceTest {

	static BankService bService;
	
	@BeforeClass
	public static void setUpToSetUp() {
		bService = new BankService();		
	}
	
	@Before
	public void setup() {
		bService = new BankService();
	}
	
	@After
	public void reset() {
		bService = new BankService();
	}
	
	@AfterClass
	public static void allDone() {
		bService = new BankService();
	}
	
	@Test
	public void viewAllAccounts() {
		bService.viewAccounts();
	}
	
	@Test
	public void checkBalance() {
		bService.checkBalance(2201);
	}
		
	@Test
	public void depositAmount() {
		bService.customerDeposit(2201);
	}
	
	@Test
	public void withdrawAmount() {
		bService.customerWithdraw(2201);
	}
	
	@Test
	public void transferAmount() {
		bService.customerTransfer(2201);
	}
	
	@Test
	public void deleteAccount() {
		bService.cancelAccount();
	}
	
	@Test
	public void updateAccount() {
		bService.editAccount();
	}
	
	@Test
	public void approveAccount() {
		bService.approveAccount();
	}
	
}

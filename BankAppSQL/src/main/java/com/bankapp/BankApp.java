package com.bankapp;

import com.bankapp.service.BankService;

public class BankApp {
		
	public static void main(String[] args) {
		
		BankService bankService = new BankService();

		bankService.mainMenu();
		
	}	

}



package com.bankapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

import com.bankapp.dao.*;
import com.bankapp.model.*;

public class BankService {

	static int accountId;
	
	final static Logger LOGGY = LogManager.getLogger(BankService.class); 
	
	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_BLACK = "\u001B[30m";
	public static final String TEXT_RED = "\u001B[31m";
	public static final String TEXT_GREEN = "\u001B[32m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_BLUE = "\u001B[34m";
	public static final String TEXT_PURPLE = "\u001B[35m";
	public static final String TEXT_CYAN = "\u001B[36m";
	public static final String TEXT_WHITE = "\u001B[37m";
	
	public static final String TEXT_BOLD = "\u001B[1m";

	
	public static final String BLACK_BACKGROUND = "\u001B[40m";
	public static final String RED_BACKGROUND = "\u001B[41m";
	public static final String GREEN_BACKGROUND = "\u001B[42m";
	public static final String YELLOW_BACKGROUND = "\u001B[43m";
	public static final String BLUE_BACKGROUND = "\u001B[44m";
	public static final String PURPLE_BACKGROUND = "\u001B[45m";
	public static final String CYAN_BACKGROUND = "\u001B[46m";
	public static final String WHITE_BACKGROUND = "\u001B[47m";
	
	
	/********************************* Bank App Main Menu **********************************/
	public void mainMenu() {
	
		LOGGY.setLevel(Level.ALL);

		Scanner sc = new Scanner(System.in);
				
		int ch = 1;
		while(ch != 4) {
			System.out.println();
			System.out.println(BLUE_BACKGROUND + TEXT_WHITE + TEXT_BOLD + "    WELCOME TO BANK APP HOME PAGE    " + TEXT_RESET);
			System.out.println(" 1. Customer Page");
			System.out.println(" 2. Employee Page");
			System.out.println(" 3. Admin Page");
			System.out.println(" 4. Exit App");
			
			boolean menu = true;
			while(menu) {
				System.out.print(BLACK_BACKGROUND + TEXT_WHITE  + TEXT_BOLD + " >> Enter your choice# " + TEXT_GREEN);
				String entry = sc.next();
				ch = getInteger(entry);
				if(ch == 4) menu = false;
				if(ch >= 1 && ch <= 3) menu = false;
				if(ch <= 0 || ch > 4) System.out.print(RED_BACKGROUND + TEXT_WHITE  + TEXT_BOLD + " Wrong choice try again... ");
			}
			
			System.out.println(TEXT_RESET);
			switch(ch) {
				case 1: customerPanel();
						break;
				case 2: employeePanel();
						break;
				case 3: adminPanel();
			}
		}	
		
		System.out.println(BLUE_BACKGROUND + TEXT_WHITE + TEXT_BOLD + "    Thank you for using Bank App     ");
		
	}
	
	/********************************* Customer Page **********************************/
	public void customerPanel() {
		
		Scanner sc = new Scanner(System.in);
		
		int ch = 1;
		while(ch != 3) {
			System.out.println();
			System.out.println(YELLOW_BACKGROUND + TEXT_BOLD + "      WELCOME TO CUSTOMER PAGE       " + TEXT_RESET);
			System.out.println(" 1. Register New Account");
			System.out.println(" 2. Login Existing Account");
			System.out.println(" 3. Return to Home");
			
			boolean menu = true;
			while(menu) {
				System.out.print(BLACK_BACKGROUND + TEXT_WHITE + TEXT_BOLD + "  > Enter your choice# " + TEXT_GREEN);
				String entry = sc.next();
				ch = getInteger(entry);
				if(ch == 3) menu = false;
				if(ch >= 1 && ch <= 2) menu = false;
				if(ch <= 0 || ch > 3) System.out.print(RED_BACKGROUND + TEXT_WHITE + TEXT_BOLD + " Wrong choice try again... ");
			}
			
			System.out.println(TEXT_RESET);
			switch(ch) {
				case 1: createAccount();
						break;
				case 2: customerLogin();
			}
		}
		
	}
	
	/********************************* Employee Page **********************************/
	public void employeePanel() {
		
		Scanner sc = new Scanner(System.in);
		int ch = 1;
		while(ch != 6) {
			System.out.println();
			System.out.println(PURPLE_BACKGROUND + TEXT_WHITE + TEXT_BOLD + "      WELCOME TO EMPLOYEE PAGE       " + TEXT_RESET);
			System.out.println(" 1. View All Accounts");
			System.out.println(" 2. Approve/Deny Account");
			System.out.println(" 3. Deposit Amount");
			System.out.println(" 4. Withdraw Amount");
			System.out.println(" 5. Transfer Amount");
			System.out.println(" 6. Return to Home");
			
			boolean menu = true;
			while(menu) {
				System.out.print(BLACK_BACKGROUND + TEXT_WHITE + TEXT_BOLD + "  > Enter your choice# " + TEXT_GREEN);
				String entry = sc.next();
				ch = getInteger(entry);
				if(ch == 6) menu = false;
				if(ch >= 1 && ch <= 5) menu = false;
				if(ch <= 0 || ch > 6) System.out.print(RED_BACKGROUND + TEXT_WHITE + TEXT_BOLD + " Wrong choice try again... ");
			}
			
			System.out.println(TEXT_RESET);
			switch(ch) {
				case 1: viewAccounts();
						break;
				case 2: approveAccount();
						break;
				case 3: depositAmount();
						break;
				case 4: withdrawAmount();
						break;
				case 5: transferAmount();
			}
		}
		
	}
	
	/********************************* Admin Page **********************************/
	public void adminPanel() {
		
		Scanner sc = new Scanner(System.in);
		int ch = 1;
		while(ch != 8) {
			System.out.println();
			System.out.println(CYAN_BACKGROUND + TEXT_BOLD + "        WELCOME TO ADMIN PAGE        " + TEXT_RESET);
			System.out.println(" 1. View All Accounts");
			System.out.println(" 2. Approve/Deny Account");
			System.out.println(" 3. Edit Account");
			System.out.println(" 4. Cancel Account");
			System.out.println(" 5. Deposit Amount");
			System.out.println(" 6. Withdraw Amount");
			System.out.println(" 7. Transfer Amount");
			System.out.println(" 8. Return to Home");
			
			boolean menu = true;
			while(menu) {
				System.out.print(BLACK_BACKGROUND + TEXT_WHITE + TEXT_BOLD + "  > Enter your choice# " + TEXT_GREEN);
				String entry = sc.next();
				ch = getInteger(entry);
				if(ch == 8) menu = false;
				if(ch >= 1 && ch <= 7) menu = false;
				if(ch <= 0 || ch > 8) System.out.print(RED_BACKGROUND + TEXT_WHITE + TEXT_BOLD + " Wrong choice try again... ");
			}
			
			System.out.println(TEXT_RESET);
			switch(ch) {
				case 1: viewAccounts();
						break;
				case 2: approveAccount();
						break;
				case 3: editAccount();
						break;
				case 4: cancelAccount();
						break;
				case 5: depositAmount();
						break;
				case 6: withdrawAmount();
						break;
				case 7: transferAmount();
			}
		}
		
	}

	/********************************* View All Accounts **********************************/
	public void viewAccounts() {
		
		List<Account> accountList = new ArrayList<>();
		List<Customer> customerList = new ArrayList<>();
		
		AccountDAOImpl allAccounts = new AccountDAOImpl();
		accountList = allAccounts.getAllAccounts();
		
		CustomerDAOImpl allCustomer = new CustomerDAOImpl();
		customerList = allCustomer.getAllCustomers();
		
		System.out.println(TEXT_BLUE + TEXT_BOLD + "                            All Bank Accounts List \n");
		System.out.println(TEXT_RESET + TEXT_BOLD + "  Acct#    Balance     Type       Status   First Name    Last Name    Phone");
		System.out.println(" ------------------------------------------------------------------------------------" + TEXT_RESET);
		
		for(Account p : accountList) {
			System.out.printf("  %d     $ %6.2f    %8s   %8s", p.getAccountId(), p.getBalance(), p.getAccountType(), p.getAccountStatus());
			for(Customer k : customerList) {
				if(k.getCustomerId() == p.getCustomerId()) {
					System.out.printf("  %10s  %10s   %15s %n", k.getFirstName(), k.getLastName(), k.getPhone());
				}
			}
		}
		System.out.println(TEXT_BOLD + " ------------------------------------------------------------------------------------\n" + TEXT_RESET);
		LOGGY.info(" LOG: All Accounts were listed from Database successfully");
		
	}

	/********************************* Create Customer Account **********************************/
	public void createAccount() {
		
		Scanner sc = new Scanner(System.in);

		boolean chk = true;
		int ch, cId, aId;
		String username = "", password, password2, fName, lName, phone = "", acType = "", secOwner = "";
		
		System.out.println(TEXT_RED  + TEXT_BOLD + "\n************* New Account Information *************" + TEXT_RESET);
		
		while(chk) {
			System.out.print(TEXT_RESET + " Username: " + TEXT_BLUE + TEXT_BOLD);
			username = sc.next();
			
			boolean user = findUser(username);
			if(user) {
				chk = false;
			} else {
				System.out.println(TEXT_RESET + TEXT_RED + TEXT_BOLD + " This user name is already exist... Try Again!!");
			}			
		}
		
		
		System.out.print(TEXT_RESET + " Password: " + BLUE_BACKGROUND + TEXT_BLUE + TEXT_BOLD);
		password = sc.next();
		
		chk = true;
		while(chk) {
			System.out.print(TEXT_RESET + " Confirm Password: " + BLUE_BACKGROUND + TEXT_BLUE + TEXT_BOLD);
			password2 = sc.next();
			
			if(password2.equals(password)) {
				chk = false;
			} else {
				System.out.println(TEXT_RESET + TEXT_RED + TEXT_BOLD + " Password Not Matched... Try Again!!");
			}
		}
		
		System.out.print(TEXT_RESET + " First Name: " + TEXT_BLUE + TEXT_BOLD);
		fName = sc.next();
		System.out.print(TEXT_RESET + " Last Name: " + TEXT_BLUE + TEXT_BOLD);
		lName = sc.next();
		
		chk = true;
		while(chk) {
			System.out.print(TEXT_RESET + " Phone Number (10 digits): " + TEXT_BLUE + TEXT_BOLD);
			phone = sc.next();
			
			boolean ph = checkPhone(phone);
			if(phone.length() == 10 && ph) {
				phone = "(" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6, 10);
				System.out.println(TEXT_RESET + "                           " + TEXT_BLUE + TEXT_BOLD + phone);
				chk = false;
			} else {
				System.out.println(TEXT_RED + TEXT_BOLD + " Invalid Phone Number... Try Again!!");
			}
		}
						
		System.out.println(TEXT_RED + "\n************** New Account Type **************" + TEXT_RESET);
		
		chk = true;
		ch = 0;
		while(chk) {
			System.out.print(TEXT_RESET + " Account Type (1. Checking  2. Saving  3.Joint): " + TEXT_BLUE + TEXT_BOLD);
			String entry = sc.next();
			ch = getInteger(entry);
			
			if(ch >= 1 && ch <= 3) {
				chk = false;
			} else {
				System.out.println(TEXT_RED + TEXT_BOLD + " Wrong Account Type... Try Again!!");
			}
		}
		
		switch(ch) {
			case 1: acType = "Checking";
					break;
			case 2: acType = "Saving";
					break;
			case 3: acType = "Joint";
		}
		
		if(ch == 3) {
			System.out.print(TEXT_RESET + " Second Owner Name: " + TEXT_BLUE + TEXT_BOLD);
			secOwner = sc.next();
		}

		// Write to Customer Table
		Customer cust = new Customer(0, username, password, fName, lName, phone);
		CustomerDAOImpl newCust = new CustomerDAOImpl();
		newCust.createCustomer(cust);

		// Write to Account Table
		int custSize = newCust.getAllCustomers().size();
		if(custSize == 0) {
			cId = custSize + 101;
		} else {
			cId = custSize + 100;
		}
		Account acct = new Account(0, 0, acType, secOwner, "Pending", cId);		
		AccountDAOImpl newAcct = new AccountDAOImpl();
		newAcct.createAccount(acct);
		
		int acctSize = newAcct.getAllAccounts().size() + 2201;
		if(acctSize == 0) {
			aId = acctSize + 2201;
		} else {
			aId = acctSize + 2200;
		}

		System.out.println(TEXT_GREEN  + TEXT_BOLD + "\n *** New Account has been created with [Pending] status for the management review and approval.\n" + TEXT_RESET);
		
		LOGGY.info(" LOG: New customer account has been created successfully");
	}
	
	/********************************* Customer Login and Transactions Menu **********************************/
	public void customerLogin() {

		Scanner sc = new Scanner(System.in);
		CustomerDAOImpl custDao = new CustomerDAOImpl();
		AccountDAOImpl acctDao = new AccountDAOImpl();
		
		String username, password;
		int customerId = 0;
		int ch = 1;
		System.out.println(TEXT_RED + TEXT_BOLD + "\n*********** Customer Login ***********" + TEXT_RESET);
		System.out.print(" Username: " + TEXT_BLUE + TEXT_BOLD);
		username = sc.next();
		System.out.print(TEXT_RESET + " Password: " + BLUE_BACKGROUND + TEXT_BLUE + TEXT_BOLD);
		password = sc.next();
		System.out.print(TEXT_RESET);
		
		// Get Password from customer record
		if(password.equals(custDao.getCustomerByUsername(username).getPassword())) {
			System.out.println(TEXT_GREEN + TEXT_BOLD + "\n *** Successful Login ***" + TEXT_RESET);
			System.out.println(TEXT_BOLD + "\n *** Welcome " + custDao.getCustomerByUsername(username).getFirstName() + " ***\n" + TEXT_RESET);
			customerId = custDao.getCustomerByUsername(username).getCustomerId();
			accountId = acctDao.getAccountByCustomerId(customerId).getAccountId();
			LOGGY.info(" LOG: Successful customer login into Database");
		} else {
			System.out.println(TEXT_RED + TEXT_BOLD + "\n *** Wrong username or password! ***\n" + TEXT_RESET);
			LOGGY.warn(" LOG: Wrong credentials for customer login");
			ch = 6;	
		}

		while(ch != 6) {
			System.out.println(TEXT_BOLD + "\n***** Customer Transcations Menu *****" + TEXT_RESET);
			System.out.println(" 1. Check Balance");
			System.out.println(" 2. Change Password");
			System.out.println(" 3. Deposit Amount");
			System.out.println(" 4. Withdraw Amount");
			System.out.println(" 5. Transfer Amount");
			System.out.println(" 6. Return to Customer Page");
		
			boolean menu = true;
			while(menu) {
				System.out.print(TEXT_BOLD + "  > Enter your choice# " + TEXT_BLUE + TEXT_BOLD);
				String entry = sc.next();
				ch = getInteger(entry);
				if(ch == 6) menu = false;
				if(ch >= 1 && ch <= 5) menu = false;
				if(ch <= 0 || ch > 6) System.out.print(TEXT_RED + TEXT_BOLD + " Wrong choice try again..." + TEXT_RESET);
			}
			
			System.out.println(TEXT_RESET);
			switch(ch) {
				case 1: checkBalance(accountId);
						break;
				case 2: changePassword(customerId);
						break;
				case 3: customerDeposit(accountId);
						break;
				case 4: customerWithdraw(accountId);
						break;
				case 5: customerTransfer(accountId);
			}
		}

	}

	/********************************* Customer Check Balance **********************************/
	public void checkBalance(int acct) {

		AccountDAOImpl acctDao = new AccountDAOImpl();
		CustomerDAOImpl custDao = new CustomerDAOImpl();
		double newBalance = 0;
		String fName = "", lName = "";
		int cust = 0;
		
		newBalance = acctDao.getAccountById(acct).getBalance();
		cust = acctDao.getAccountById(acct).getCustomerId();
		fName = custDao.getCustomerById(cust).getFirstName();
		lName = custDao.getCustomerById(cust).getLastName();
		System.out.println(" Account# " + TEXT_BLUE + TEXT_BOLD + acct + TEXT_RESET + "      Name: " + TEXT_BLUE + TEXT_BOLD + fName + " " + lName + TEXT_RESET);
		System.out.println("                 Balance: " + TEXT_BLUE + TEXT_BOLD + "$ " + newBalance + TEXT_RESET + "\n");
		LOGGY.info(" LOG: Customer Balance was accessed from Databse successfully");
	}

	/********************************* Change Password **********************************/
	public void changePassword(int cust) {

		Scanner sc = new Scanner(System.in);
		CustomerDAOImpl custDao = new CustomerDAOImpl();
		String oldPassword = custDao.getCustomerById(cust).getPassword();
		String password = "", newPassword = "", password2 = "";
		
		boolean chk = true;
		while(chk) {
			System.out.print(TEXT_RESET + " Old Password: " + BLUE_BACKGROUND + TEXT_BLUE + TEXT_BOLD);
			password = sc.next();
			
			if(password.equals(oldPassword)) {
				chk = false;
			} else {
				System.out.println(TEXT_RED + TEXT_BOLD + WHITE_BACKGROUND + " Wrong Old Password... Try Again!!");
			}			
		}		
		
		chk = true;
		while(chk) {
			System.out.print(TEXT_RESET + " New Password: " + BLUE_BACKGROUND + TEXT_BLUE + TEXT_BOLD);
			newPassword = sc.next();
			
			if(!newPassword.equals(oldPassword)) {
				chk = false;
			} else {
				System.out.println(TEXT_RED + TEXT_BOLD + WHITE_BACKGROUND + " New Password is the same of Old Password... Try Again!!");
			}
		}
		
		chk = true;
		while(chk) {
			System.out.print(TEXT_RESET + " Confirm Password: " + BLUE_BACKGROUND + TEXT_BLUE + TEXT_BOLD);
			password2 = sc.next();
			
			if(password2.equals(newPassword)) {
				chk = false;
			} else {
				System.out.println(TEXT_RESET + TEXT_RED + TEXT_BOLD + " Password Not Matched... Try Again!!");
			}
		}
		
		custDao.changePassword(cust, newPassword);
		System.out.println(TEXT_RESET + TEXT_GREEN + TEXT_BOLD + "\n Password has been changed successfully \n" + TEXT_RESET);
		LOGGY.info(" LOG: Customer Password Changed");
	}

	/********************************* Customer Deposit Amount **********************************/
	public void customerDeposit(int acct) {

		Scanner sc = new Scanner(System.in);
		AccountDAOImpl acctDao = new AccountDAOImpl();

		double newBalance = 0;
		double oldBalance = 0;
		double deposit = 0;
		
		oldBalance = acctDao.getAccountById(acct).getBalance();
	    if(acctDao.getAccountById(acct).getAccountStatus().equals("Approved")){
	    	
		  	boolean chk = true;
		  	while(chk) {
	    	  System.out.print(TEXT_RESET + " Balance " + TEXT_BOLD + "($ " + oldBalance + ")" + TEXT_RESET + ", enter the deposit amount: " + TEXT_BLUE + TEXT_BOLD);
		  	  String entry = sc.next();
		  	  deposit = getDouble(entry);
		  	  
		  	  if(deposit > 0) {
		  		  chk = false;
		  	  } else {
		  		System.out.println(TEXT_RED + TEXT_BOLD + "\n Invalid amount!" + TEXT_RESET);
		  	  }
		  	}
		  	  
			newBalance = oldBalance + deposit;
			acctDao.depositAmount(acct, deposit);
			System.out.println(TEXT_RESET + "\n Account# " + TEXT_BLUE + TEXT_BOLD + acct + TEXT_RESET + "    Old Balance: " + TEXT_BLUE + TEXT_BOLD + "$ " + oldBalance + TEXT_RESET + "    New Balance: " + TEXT_BLUE + TEXT_BOLD +"$ " + newBalance + TEXT_RESET + "\n");
     		LOGGY.info(" LOG: Deposit was done and saved into Database successfully");

	    } else {
			  System.out.println(TEXT_RED + TEXT_BOLD + "\n This account is not Approved yet.. Transaction Denied." + TEXT_RESET);
		}

	}
	
	/********************************* Customer Withdraw Amount **********************************/
	public void customerWithdraw(int acct) {
		
		Scanner sc = new Scanner(System.in);
		AccountDAOImpl acctDao = new AccountDAOImpl();

		double newBalance = 0;
		double oldBalance = 0;
		double withdraw = 0;
		
		oldBalance = acctDao.getAccountById(acct).getBalance();
	    if(acctDao.getAccountById(acct).getAccountStatus().equals("Approved")){
	    	
		  	boolean chk = true;
		  	while(chk) {
	    	  System.out.print(TEXT_RESET + " Balance " + TEXT_BOLD + "($ " + oldBalance + ")" + TEXT_RESET + ", enter the withdraw amount: " + TEXT_BLUE + TEXT_BOLD);
			  String entry = sc.next();
			  withdraw = getDouble(entry);
			  
			  if(withdraw > 0) {
				  chk = false;
			  } else {
				  System.out.println(TEXT_RED + TEXT_BOLD + "\n Invalid amount!" + TEXT_RESET);
			  }
		  	}
			  
			  if(withdraw > oldBalance) {
				  System.out.println(TEXT_RED + TEXT_BOLD + "\n Insufficient fund for this withdrwal transaction.. Transaction Denied." + TEXT_RESET);
			  } else {
				  newBalance = oldBalance - withdraw;
				  acctDao.withdrawAmount(acct, withdraw);
				  System.out.println(TEXT_RESET + "\n Account# " + TEXT_BLUE + TEXT_BOLD + acct + TEXT_RESET + "    Old Balance: " + TEXT_BLUE + TEXT_BOLD + "$ " + oldBalance + TEXT_RESET + "    New Balance: " + TEXT_BLUE + TEXT_BOLD +"$ " + newBalance + TEXT_RESET + "\n");
				  LOGGY.info(" LOG: Withdraw was done and saved into Database successfully");
			  }

	    } else {
			  System.out.println(TEXT_RED + TEXT_BOLD + "\n This account is not Approved yet.. Transaction Denied." + TEXT_RESET);
		}
	
	}
	
	/********************************* Customer Transfer Amount **********************************/
	public void customerTransfer(int acct) {
		
		Scanner sc = new Scanner(System.in);
		AccountDAOImpl acctDao = new AccountDAOImpl();

		double newBalance = 0;
		double oldBalance = 0;
		double transfer = 0;
		int acct2 = 0;
		int ac = 0;
		int prev = 0;
		boolean chk = false;
		
		oldBalance = acctDao.getAccountById(acct).getBalance();
	    if(acctDao.getAccountById(acct).getAccountStatus().equals("Approved")){
	    	
		  	  System.out.print(TEXT_RESET + " Enter Account# to transfer to: " + TEXT_BLUE + TEXT_BOLD);
			  String entry = sc.next();
			  ac = getInteger(entry);
			  
			  boolean found = findAccount(ac);
			  if(ac > 0 && found) {
				  acct2 = acctDao.getAccountById(ac).getAccountId();
		    	  if(acctDao.getAccountById(acct2).getAccountStatus().equals("Approved")) {
					  chk = true;
				  }
			  }	else {
				  System.out.println(TEXT_RED + TEXT_BOLD + "\n Invalid Account#" + TEXT_RESET);
				  prev = 1;
			  }
			  
			  if(acct2 > 0 && chk) {
				  while(chk) {
				  	  System.out.print(TEXT_RESET + " Balance " + TEXT_BOLD + "($ " + oldBalance + ")" + TEXT_RESET + ", enter the transfer amount: " + TEXT_BLUE + TEXT_BOLD);
					  entry = sc.next();
					  transfer = getDouble(entry);
					  
					  if(transfer > 0) {
						  chk = false;
					  } else {
						  System.out.println(TEXT_RED + TEXT_BOLD + "\n Invalid amount!" + TEXT_RESET);
					  }
				  }
			  }
			  
			  if(transfer > oldBalance && found) {
				  System.out.println(TEXT_RED + TEXT_BOLD + "\n Insufficient fund for this transfer transaction.. Transaction Denied." + TEXT_RESET);
			  } else if(transfer > 0 && found) {
				  newBalance = oldBalance - transfer;
				  acctDao.transferAmount(acct, acct2, transfer);
				  System.out.println(TEXT_RESET + "\n Account# " + TEXT_BLUE + TEXT_BOLD + acct+ TEXT_RESET + "    Old Balance: " + TEXT_BLUE + TEXT_BOLD + "$ " + oldBalance + TEXT_RESET + "    New Balance: " + TEXT_BLUE + TEXT_BOLD +"$ " + newBalance + TEXT_RESET + "\n");
				  LOGGY.info(" LOG: Transfer was done and saved into Database successfully");
			  } else if(!chk && acct > 0) {
				     if(prev == 0) System.out.println(TEXT_RED + TEXT_BOLD + "\n Account# " + ac + " is not Approved yet.. Transaction Denied." + TEXT_RESET);
			  } 
	     } else {
			  System.out.println(TEXT_RED + TEXT_BOLD + "\n This account is not Approved yet.. Transaction Denied." + TEXT_RESET);
		 }

	}
	
	/********************************* Deposit Amount **********************************/
	public void depositAmount() {

		Scanner sc = new Scanner(System.in);

		System.out.print("\n Enter Account# for deposit: " + TEXT_BLUE + TEXT_BOLD);
		String entry = sc.next();
		int acct = getInteger(entry);

		boolean found = findAccount(acct);
		if(acct > 0 && found) {
			customerDeposit(acct);
		} else {
			System.out.println(TEXT_RED + TEXT_BOLD + "\n Invalid Account#" + TEXT_RESET);
		}
		
	}
	
	/********************************* Withdraw Amount **********************************/
	public void withdrawAmount() {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("\n Enter Account# for withdraw: " + TEXT_BLUE + TEXT_BOLD);
		String entry = sc.next();
		int acct = getInteger(entry);

		boolean found = findAccount(acct);
		if(acct > 0  && found) {
			customerWithdraw(acct);
		} else {
			System.out.println(TEXT_RED + TEXT_BOLD + "\n Invalid Account#" + TEXT_RESET);
		}		
		
	}
	
	/********************************* Transfer Amount **********************************/
	public void transferAmount() {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("\n Enter Account# to transfer from: " + TEXT_BLUE + TEXT_BOLD);
		String entry = sc.next();
		int acct = getInteger(entry);
		
		boolean found = findAccount(acct);
		if(acct > 0 && found) {
			customerTransfer(acct);
		} else {
			System.out.println(TEXT_RED + TEXT_BOLD + "\n Invalid Account#" + TEXT_RESET);
		}

	}

	/********************************* Cancel Account **********************************/
	public void cancelAccount() {
		
		Scanner sc = new Scanner(System.in);

		System.out.print(" Enter Account# to be deleted: " + TEXT_BLUE + TEXT_BOLD);
		String entry = sc.next();
		int acct = getInteger(entry);
		
		boolean found = findAccount(acct);
		AccountDAOImpl findAccount = new AccountDAOImpl();
		CustomerDAOImpl cancelCustomer = new CustomerDAOImpl();
		
		if(acct > 0 && found) {
			int cust = findAccount.getAccountById(acct).getCustomerId();
			cancelCustomer.deleteCustomer(cust);
			System.out.println(TEXT_GREEN + TEXT_BOLD + "\n Account# [" + acct + "] deleted successfully \n" + TEXT_RESET);
			LOGGY.info(" LOG: Account was deleted successfully");
		} else {
			System.out.println(TEXT_RED + TEXT_BOLD + "\n Invalid Account#" + TEXT_RESET);
		}
		
	}
	
	/********************************* Edit Account **********************************/
	public void editAccount() {

		Scanner sc = new Scanner(System.in);
		
		System.out.print(" Enter Account# to be edited: " + TEXT_BLUE + TEXT_BOLD);
		String entry = sc.next();
		int acct = getInteger(entry);
		int x = 0;

		boolean found = findAccount(acct);

		AccountDAOImpl getAccount = new AccountDAOImpl();
		CustomerDAOImpl getCustomer = new CustomerDAOImpl();
		
		if(acct > 0 && found) {
			double balance = getAccount.getAccountById(acct).getBalance();
			int cId = getAccount.getAccountById(acct).getCustomerId();
			String fName = getCustomer.getCustomerById(cId).getFirstName();
			String lName = getCustomer.getCustomerById(cId).getLastName();
			String type = getAccount.getAccountById(acct).getAccountType();
			String status = getAccount.getAccountById(acct).getAccountStatus();
			String joint = getAccount.getAccountById(acct).getSecondOwner();
			
			System.out.println(TEXT_RESET + TEXT_BLUE + "\n Customer#: " + TEXT_BOLD + cId + TEXT_RESET + TEXT_BLUE + "   Customer Name: " + TEXT_BOLD + fName + " " + lName);
			System.out.println(TEXT_RESET + TEXT_BLUE + " Account Balance " + TEXT_BOLD + "($ " + balance + ") \n");
			
			boolean chk = true;
			while(chk) {
				System.out.print(TEXT_RESET + " Account Type " + TEXT_BOLD + "(" + type + ")" + TEXT_RESET + " 1. Checking  2. Saving  3. Joint: " + TEXT_BLUE + TEXT_BOLD);
				entry = sc.next();
				x = getInteger(entry);
				if(x >= 1 && x <= 3) {
					chk = false;
				} else {
					System.out.println(TEXT_RED + TEXT_BOLD + " Wrong Account Type... Try Again!!");
				}
			}
			
			switch(x) {
				case 0: type = getAccount.getAccountById(acct).getAccountType();
						joint = getAccount.getAccountById(acct).getSecondOwner();
						break;
				case 1: type = "Checking";
						break;
				case 2: type = "Saving";
						break;
				case 3: type = "Joint";
					    System.out.print(TEXT_RESET + "         Second Owner Name " + TEXT_BOLD + "(" + joint + ")" + TEXT_RESET +": " + TEXT_BLUE + TEXT_BOLD);
					    joint = sc.next();
					    if(joint.equals("0")) {
						    joint = getAccount.getAccountById(acct).getSecondOwner(); 
					    }
			}
	
			chk = true;
			while(chk) {
				System.out.print(TEXT_RESET + " Account Status " + TEXT_BOLD + "(" + status + ")" + TEXT_RESET + " 1. Approved  2. Denied  3. Pending: " + TEXT_BLUE + TEXT_BOLD);
				entry = sc.next();
				x = getInteger(entry);
				if(x >= 1 && x <= 3) {
					chk = false;
				} else {
					System.out.println(TEXT_RED + TEXT_BOLD + " Wrong Account Status... Try Again!!");
				}
			}
			
			switch(x) {
				case 0: status = getAccount.getAccountById(acct).getAccountStatus();
						break;
				case 1: status = "Approved";
						break;
				case 2: status = "Denied";
						break;
				case 3: status = "Pending";
			}
			
			Account custAccount = new Account(acct, balance, type, joint, status, cId);
			AccountDAOImpl updateAccount = new AccountDAOImpl();
			updateAccount.updateAccount(custAccount);
			System.out.println(TEXT_GREEN + TEXT_BOLD + "\n Account# " + acct + " has been updated for Customer# " + cId + TEXT_RESET + "\n");
			LOGGY.info(" LOG: Account was updated successfully");	
		} else {
			System.out.println(TEXT_RED + TEXT_BOLD + "\n Invalid Account#" + TEXT_RESET);
		}
	}
	
	/********************************* Approve Account **********************************/
	public void approveAccount() {
		
		Scanner sc = new Scanner(System.in);
		List<Account> accountList = new ArrayList<>();
		String entry = "";
		int acct = 0;
		int action = 0;

		AccountDAOImpl pendingAccount = new AccountDAOImpl();
		accountList = pendingAccount.getNotApprovedAccounts();
		
		int getSize = accountList.size();
		if(getSize > 0) {
			System.out.println(TEXT_BLUE + TEXT_BOLD + "  Pending/Denied Accounts List \n");
			System.out.println(TEXT_RESET + TEXT_BOLD + "  Acct#    Type       Status");
			System.out.println(" ------------------------------" + TEXT_RESET);
			
			for(Account p : accountList) {
				System.out.printf("  %d     %7s  %8s %n", p.getAccountId(), p.getAccountType(), p.getAccountStatus());
			}
			System.out.println(TEXT_BOLD + " ------------------------------" + TEXT_RESET);
			
			System.out.print("\n Enter Account# " + TEXT_BLUE + TEXT_BOLD);
			entry = sc.next();
			acct = getInteger(entry);
			
			boolean found = false;
			for(Account p : accountList) {
				if(p.getAccountId() == acct) found = true;
			}
			
			if(found) {
				boolean chk = true;
				while(chk) {
					System.out.print(TEXT_RESET + "\n Action (1. Approved  2. Denied): " + TEXT_BLUE + TEXT_BOLD);
					entry = sc.next();
					action = getInteger(entry);
					
					if(action >= 1 && action <= 2) {
						chk = false;
					} else {
						System.out.println(TEXT_RED + TEXT_BOLD + " Wrong Action... Try Again!!");
					}
				}
				
				String status = "";
				switch(action) {
					case 1: status = "Approved";
							break;
					case 2: status = "Denied";
				}
				
				if(action == 1 || action == 2) {
					AccountDAOImpl approveAccount = new AccountDAOImpl();
					approveAccount.changeAccountStatus(acct, status);
					System.out.println(TEXT_RESET + "\n Status for Account# " + TEXT_BOLD + acct + TEXT_RESET + " changed to " + TEXT_BOLD + status + TEXT_RESET + "\n");
					LOGGY.info(" LOG: Account changed its status successfully");	
				} else {
					System.out.println(TEXT_RED + TEXT_BOLD + "\n Wrong choice..." + TEXT_RESET);
				}
			} else {
				System.out.println(TEXT_RED + TEXT_BOLD + "\n Invalid Account# (Not in Pending/Denied List)" + TEXT_RESET);
			}
		} else {
			System.out.println(TEXT_GREEN + TEXT_BOLD + "\n No Pending/Denied accounts for Approval or Review \n" + TEXT_RESET);				
		}
		
	}
	
	/********************************* Check Integer **********************************/
	public Integer getInteger(String entry) {
		
		int intValue = 0;
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-' };
		String number = "";
		int count = 0;
		
		for(int i = 0; i < entry.length(); i++)
			for(char d : digits) if(d == entry.charAt(i)) {
				++count;
				number += d;
			 }

		if(count > 0 && count == entry.length()) {
			intValue = Integer.valueOf(number);
		}
		
		return intValue;
		
	}
	
	/********************************* Check Double **********************************/
	public Double getDouble(String entry) {
		
		double doubleValue = 0;
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '.' };
		String number = "";
		int count = 0;
		
		for(int i = 0; i < entry.length(); i++)
			for(char d : digits) if(d == entry.charAt(i)) {
									++count;
									number += d;
								 }

		if(count > 0 && count == entry.length()) {
			doubleValue = Double.valueOf(number);
		}
		
		return doubleValue;
		
	}
	
	/********************************* Find Account **********************************/
	public Boolean findAccount(Integer acct) {
		
		List<Account> accountList = new ArrayList<>();

		AccountDAOImpl allAccounts = new AccountDAOImpl();
		accountList = allAccounts.getAllAccounts();
		
		boolean found = false;
		for(Account p : accountList) {
			if(p.getAccountId() == acct) {
				found = true;
				break;
			}
			
		}
		
		return found;
		
	}
	
	/********************************* Find User **********************************/
	public Boolean findUser(String user) {
		
		List<Customer> customerList = new ArrayList<>();

		CustomerDAOImpl allCustomers = new CustomerDAOImpl();
		customerList = allCustomers.getAllCustomers();
		
		boolean found = true;
		for(Customer p : customerList) {
			if(p.getUsername().equals(user)) {
				found = false;
				break;
			}
		}
		
		return found;
		
	}

	/********************************* Check Phone Number **********************************/
	public Boolean checkPhone(String phone) {
		
		boolean found = false;
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int count = 0;
		
		for(int i = 0; i < phone.length(); i++)
			for(char d : digits) if(d == phone.charAt(i)) {
				++count;
			 }

		if(count > 0 && count == phone.length()) {
			found = true;
		}

		return found;
		
	}

}

package com.bankapp.model;

public class Account {
	
	private int accountId;
	private double balance;
	private String accountType;
	private String secondOwner;
	private String accountStatus;
	private int customerId;
	
	public Account() {
		super();
	}

	public Account(int accountId, double balance, String accountType, String secondOwner, String accountStatus, int customerId) {
		this();
		this.accountId = accountId;
		this.balance = balance;
		this.accountType = accountType;
		this.secondOwner = secondOwner;
		this.accountStatus = accountStatus;
		this.customerId = customerId;
	}

	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getSecondOwner() {
		return secondOwner;
	}

	public void setSecondOwner(String secondOwner) {
		this.secondOwner = secondOwner;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", accountType=" + accountType
				+ ", secondOwner=" + secondOwner + ", accountStatus=" + accountStatus + ", customerId=" + customerId
				+ "]";
	}

}

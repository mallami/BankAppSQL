package com.bankapp.dao;

import java.util.List;

import com.bankapp.model.Account;

public interface AccountDAO {
	
	public void createAccount(Account ac);
	public Account getAccountById(Integer accountId);
	public Account getAccountByCustomerId(Integer customerId);
	public List<Account> getAllAccounts();
	public List<Account> getNotApprovedAccounts();
	public void updateAccount(Account ac);
	public void deleteAccount(Integer accountId);

}

package com.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.model.Account;
import com.bankapp.util.ConnectionFactory;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public void createAccount(Account ac) {

		String sql = "INSERT INTO account (balance, account_type, second_owner_name, account_status, customer_id) "
					+ "VALUES (0, ?, ?, 'Pending', ?)";
		
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ac.getAccountType());
			ps.setString(2, ac.getSecondOwner());
			ps.setInt(3, ac.getCustomerId());
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Account getAccountById(Integer accountId) {

		Account account = null;
		String sql = " SELECT * FROM account WHERE account_id = ?";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rs.getInt("account_id");
			}

			account = new Account(
					rs.getInt("account_id"), 
					rs.getDouble("balance"), 
					rs.getString("account_type"),
					rs.getString("second_owner_name"),
					rs.getString("account_status"),
					rs.getInt("customer_id"));
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return account;
		
	}

	@Override
	public Account getAccountByCustomerId(Integer customerId) {

		Account account = null;
		String sql = " SELECT * FROM account WHERE customer_id = ?";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rs.getInt("account_id");
			}

			account = new Account(
					rs.getInt("account_id"), 
					rs.getDouble("balance"), 
					rs.getString("account_type"),
					rs.getString("second_owner_name"),
					rs.getString("account_status"),
					rs.getInt("customer_id"));
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return account;
		
	}

	@Override
	public List<Account> getAllAccounts() {
		
		List<Account> accounts = new ArrayList<>();
		
		String sql = "SELECT * FROM account AS a INNER JOIN customer AS c ON a.customer_id = c.customer_id";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				accounts.add(new Account(
						rs.getInt("account_id"), 
						rs.getDouble("balance"), 
						rs.getString("account_type"),
						rs.getString("second_owner_name"),
						rs.getString("account_status"),
						rs.getInt("customer_id")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return accounts;
		
	}

	@Override
	public List<Account> getNotApprovedAccounts() {
		
		List<Account> accounts = new ArrayList<>();
		
		String sql = "SELECT * FROM account WHERE account_status <> 'Approved'";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				accounts.add(new Account(
						rs.getInt("account_id"), 
						rs.getDouble("balance"), 
						rs.getString("account_type"),
						rs.getString("second_owner_name"),
						rs.getString("account_status"),
						rs.getInt("customer_id")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return accounts;
		
	}

	@Override
	public void updateAccount(Account ac) {

		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "UPDATE account SET account_type = ?, second_owner_name = ?, account_status = ? "
						+ "WHERE account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ac.getAccountType());
			ps.setString(2, ac.getSecondOwner());
			ps.setString(3, ac.getAccountStatus());
			ps.setInt(4, ac.getAccountId());
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAccount(Integer accountId) {

		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "DELETE FROM account WHERE account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountId);
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void changeAccountStatus(Integer accountId, String accountStatus) {

		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "UPDATE account SET account_status = ? WHERE account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, accountStatus);
			ps.setInt(2, accountId);
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void depositAmount(Integer accountId, Double amount) {

		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "UPDATE account SET balance = balance + ? WHERE account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, accountId);
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void withdrawAmount(Integer accountId, Double amount) {

		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "UPDATE account SET balance = balance - ? WHERE account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, accountId);
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void transferAmount(Integer accountId1, Integer accountId2, Double amount) {

		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "UPDATE account SET balance = balance - ? WHERE account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, accountId1);
			
			ps.execute();
		
			sql = "UPDATE account SET balance = balance + ? WHERE account_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, accountId2);
			
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
}

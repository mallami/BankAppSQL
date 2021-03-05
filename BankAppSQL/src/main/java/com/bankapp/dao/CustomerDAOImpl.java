package com.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.model.Customer;
import com.bankapp.util.ConnectionFactory;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void createCustomer(Customer c) {

		String sql = "INSERT INTO customer (username, passwd, first_name, last_name, phone) "
					+ "VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getFirstName());
			ps.setString(4, c.getLastName());
			ps.setString(5, c.getPhone());
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Customer getCustomerById(Integer customerId) {

		Customer customer = null;
		String sql = "SELECT * FROM customer WHERE customer_id = ?";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rs.getInt("customer_id");
			}
			
			customer = new Customer(
					rs.getInt("customer_id"), 
					rs.getString("username"), 
					rs.getString("passwd"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("phone"));
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return customer;
		
	}

	@Override
	public Customer getCustomerByUsername(String username) {

		Customer customer = null;
		String sql = " SELECT * FROM customer WHERE username = ?";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rs.getInt("customer_id");
			}
			
			customer = new Customer(
					rs.getInt("customer_id"), 
					rs.getString("username"), 
					rs.getString("passwd"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("phone"));
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return customer;
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> customers = new ArrayList<>();
		
		String sql = "SELECT * FROM customer";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				customers.add(new Customer(
						rs.getInt("customer_id"), 
						rs.getString("username"), 
						rs.getString("passwd"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("phone")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return customers;

	}

	@Override
	public void updateCustomer(Integer customerId, String firstName, String lastName, String phone) {

		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "UPDATE customer SET first_name = ?, last_name = ?, phone = ? "
						+ "WHERE customer_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, phone);
			ps.setInt(4, customerId);
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCustomer(Integer customerId) {

		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "DELETE FROM customer WHERE customer_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void changePassword(Integer customerId, String password) {

		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "UPDATE customer SET passwd = ? WHERE customer_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, customerId);
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}

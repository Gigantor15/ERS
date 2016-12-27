package com.ers.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.beans.ERS_USERS;
import com.ers.beans.ERS_USER_ROLES;
import com.ers.dao.ERS_USERS_DAO;
import com.ers.middle.ServiceLocator;

public class ERS_USERS_IMPL implements ERS_USERS_DAO {

	private static Connection conn;

	public ERS_USERS_IMPL() throws SQLException {
		conn = ServiceLocator.getERSDatabase().getConnection();	
		//this.conn = conn;
	}
	
	public void close() throws SQLException {
		conn.close();

	}


	public ERS_USERS findUser(String username, String password) throws SQLException {
		ERS_USERS result = null;

		String sql = "SELECT ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID FROM ERS_USERS WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ERS_USER_ROLES roles;
				if(rs.getInt("USER_ROLE_ID")==1){
					roles = new ERS_USER_ROLES(1, "Manager");
				}
				else{
					roles = new ERS_USER_ROLES(2, "Employee");
				}
				// get values from row
				int id = rs.getInt("ERS_USERS_ID");
				String user = rs.getString("ERS_USERNAME");
				String pass = rs.getString("ERS_PASSWORD");
				String firstname = rs.getString("USER_FIRST_NAME");
				String lastname = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				//int roleId = rs.getInt("USER_ROLE_ID");
				result = new ERS_USERS(id, user, pass, firstname, lastname, email, roles);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}




}

package com.ers.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.beans.ERS_USERS;
import com.ers.beans.ERS_USER_ROLES;
import com.ers.dao.ERS_USERS_DAO;

public class ERS_USERS_IMPL implements ERS_USERS_DAO{

	private Connection conn;

	
	
	public ERS_USERS_IMPL(Connection conn) {
		super();
		this.conn = conn;
	}



	public ERS_USERS getByUsername(String user) {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ERS_USERS result = null;
		
		String sql = "SELECT ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID FROM ERS_USERS WHERE ERS_USERNAME = ?";
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user);
			rs = stmt.executeQuery();
			while(rs.next()){
				//get values from row
				int id = rs.getInt("ERS_USERS_ID");
				String username = rs.getString("ERS_USERNAME");
				String password = rs.getString("ERS_PASSWORD");
				String firstname = rs.getString("USER_FIRST_NAME");
				String lastname = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				int roleId = rs.getInt("USER_ROLE_ID");
				//ERS_USER_ROLES roleId = new ERS_USER_ROLES(rs.getInt("ERS_USER_ROLE_ID"), rs.getString("USER_ROLE"));
				ERS_USERS obj = new ERS_USERS(id, username, password, firstname, lastname, email, roleId);
				result = new ERS_USERS(id, username, password, firstname, lastname, email, roleId);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		return result;
	}





	

	

}

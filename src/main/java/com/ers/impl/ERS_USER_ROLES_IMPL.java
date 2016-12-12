package com.ers.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ers.beans.ERS_USERS;
import com.ers.beans.ERS_USER_ROLES;
import com.ers.dao.ERS_USER_ROLES_DAO;

public class ERS_USER_ROLES_IMPL implements ERS_USER_ROLES_DAO{
	
	private Connection conn;
	
	public ERS_USER_ROLES_IMPL() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(URL, USER, PASS);
	}

	public ERS_USER_ROLES getById(int roleId) {
		return null;
		/*ResultSet rs = null;
		PreparedStatement stmt = null;
		ERS_USER_ROLES result = null;
		
		String sql = "SELECT ERS_USER_ROLE_ID, USER_ROLE FROM ERS_USER_ROLES WHERE ERS_USER_ROLE_ID = ?";
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "ERS_USER_ROLE_ID");
			rs = stmt.executeQuery();
			while(rs.next()){
				//get values from row
				int id = rs.getInt("ERS_USER_ROLE_ID");
				String role = rs.getString("USER_ROLE");
				
				ERS_USER_ROLES obj = new ERS_USER_ROLES(id, role);
				result = obj;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		return result;*/
	}

	
	public void close() throws SQLException {
		conn.close();
		
	}


}

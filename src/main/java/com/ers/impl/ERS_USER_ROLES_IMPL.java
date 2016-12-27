package com.ers.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.beans.ERS_USER_ROLES;
import com.ers.dao.ERS_USER_ROLES_DAO;
import com.ers.middle.ServiceLocator;

public class ERS_USER_ROLES_IMPL implements ERS_USER_ROLES_DAO{
	
	private Connection conn;
	
	public ERS_USER_ROLES_IMPL() throws ClassNotFoundException, SQLException{
		conn = ServiceLocator.getERSDatabase().getConnection();
		//this.conn = conn;
	}

	public List<ERS_USER_ROLES> queryAll() throws SQLException {
		List<ERS_USER_ROLES> list = new ArrayList<>();
		String sql = "Select ERS_USER_ROLE_ID, USER_ROLE FROM ERS_USER_ROLES";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		mapRows(rs,list);
		return list;
	}
	
	private void mapRows(ResultSet rs, List<ERS_USER_ROLES> list) throws SQLException{
		while(rs.next()){
			//get values from row
			ERS_USER_ROLES role = new ERS_USER_ROLES(
					rs.getInt("ERS_USER_ROLE_ID"),
					rs.getString("USER_ROLE")
					);
			list.add(role);
			
		}
		
	}
	public void close() throws SQLException {
		conn.close();
		
	}

	


}

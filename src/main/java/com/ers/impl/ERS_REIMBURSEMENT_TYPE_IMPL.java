package com.ers.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ers.beans.ERS_REIMBURSEMENT_TYPE;
import com.ers.dao.ERS_REIMBURSEMENT_TYPE_DAO;

public class ERS_REIMBURSEMENT_TYPE_IMPL implements ERS_REIMBURSEMENT_TYPE_DAO{


	private Connection conn;
	
	public ERS_REIMBURSEMENT_TYPE_IMPL() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(URL, USER, PASS);
	}
	
	public ERS_REIMBURSEMENT_TYPE reimbType(String type) {
		return null;
		/*ResultSet rs = null;
		PreparedStatement stmt = null;
		ERS_REIMBURSEMENT_TYPE result = null;
		
		String sql = "SELECT REIMB_TYPE_ID, REIMB_TYPE FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID = ?";
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "REIMB_TYPE_ID");
			rs = stmt.executeQuery();
			while(rs.next()){
				//get values from row
				int id = rs.getInt("REIMB_TYPE_ID");
				String reimbType = rs.getString("REIMB_TYPE");
			
				ERS_REIMBURSEMENT_TYPE obj = new ERS_REIMBURSEMENT_TYPE(id, reimbType);
				result = obj;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		return result;*/
	}

}

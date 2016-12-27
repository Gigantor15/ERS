package com.ers.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.beans.ERS_REIMBURSEMENT_TYPE;
import com.ers.dao.ERS_REIMBURSEMENT_TYPE_DAO;
import com.ers.middle.ServiceLocator;

public class ERS_REIMBURSEMENT_TYPE_IMPL implements ERS_REIMBURSEMENT_TYPE_DAO{


	private Connection conn;

	
	
	public ERS_REIMBURSEMENT_TYPE_IMPL() throws SQLException {
		conn = ServiceLocator.getERSDatabase().getConnection();
		//this.conn = conn;
	}
	

	public List<ERS_REIMBURSEMENT_TYPE> queryAll() throws SQLException {
		List<ERS_REIMBURSEMENT_TYPE> list = new ArrayList<>();
		String sql = "SELECT REIMB_TYPE_ID, REIMB_TYPE FROM ERS_REIMBURSEMENT_TYPE";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		mapRows(rs,list);
		return list;
	}

	private void mapRows(ResultSet rs, List<ERS_REIMBURSEMENT_TYPE> list) throws SQLException{
		while(rs.next()){
			//get values from row
			ERS_REIMBURSEMENT_TYPE role = new ERS_REIMBURSEMENT_TYPE(
					rs.getInt("REIMB_TYPE_ID"),
					rs.getString("REIMB_TYPE")
					);
			list.add(role);
			
		}
		
	}
	
	public String getType(int id) throws SQLException {
		String type = null;
		String sql = "SELECT REIMB_TYPE FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			type = rs.getString("REIMB_TYPE");
		}
		return type;
	}
	
	public void close() throws SQLException{
		conn.close();
	}



}

package com.ers.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.beans.ERS_REIMBURSEMENT_STATUS;
import com.ers.dao.ERS_REIMBURSEMENT_STATUS_DAO;
import com.ers.middle.ServiceLocator;

public class ERS_REIMBURSEMENT_STATUS_IMPL implements ERS_REIMBURSEMENT_STATUS_DAO{

	private Connection conn;
	
	public ERS_REIMBURSEMENT_STATUS_IMPL() throws ClassNotFoundException, SQLException{
		conn = ServiceLocator.getERSDatabase().getConnection();
		//this.conn = conn;
	}
	public List<ERS_REIMBURSEMENT_STATUS> queryAll() throws SQLException {
		List<ERS_REIMBURSEMENT_STATUS> list = new ArrayList<>();
		String sql = "Select REIMB_STATUS_ID, REIMB_STATUS FROM ERS_REIMBURSEMENT_STATUS";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		mapRows(rs,list);
		return list;
		
	}

	private void mapRows(ResultSet rs, List<ERS_REIMBURSEMENT_STATUS> list) throws SQLException{
		while(rs.next()){
			//get values from row
			ERS_REIMBURSEMENT_STATUS role = new ERS_REIMBURSEMENT_STATUS(
					rs.getInt("REIMB_STATUS_ID"),
					rs.getString("REIMB_STATUS")
					);
			list.add(role);
			
		}
		
	}
	
	public String getStatus(int id) throws SQLException {
		String sql = "Select REIMB_STATUS_ID, REIMB_STATUS FROM ERS_REIMBURSEMENT_STATUS WHERE REIMB_STATUS_ID = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		String status = null;
		if(rs.next()){
			status = rs.getString("REIMB_STATUS");
		}
		return status;
	}
	
	
	public void close() throws SQLException {
		conn.close();
		
	}
	
}

package com.ers.dao;

import java.sql.SQLException;
import java.util.List;

import com.ers.beans.ERS_REIMBURSEMENT_STATUS;

public interface ERS_REIMBURSEMENT_STATUS_DAO {

	//update
	
	//List all the statuses
	public List<ERS_REIMBURSEMENT_STATUS> queryAll() throws SQLException;
	
	//get just the status
	public String getStatus(int id) throws SQLException;
}

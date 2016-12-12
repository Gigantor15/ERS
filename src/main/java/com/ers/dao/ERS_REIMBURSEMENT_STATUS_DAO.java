package com.ers.dao;

import java.util.List;

import com.ers.beans.ERS_REIMBURSEMENT_STATUS;

public interface ERS_REIMBURSEMENT_STATUS_DAO {

	public static final 	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final	String USER = "ers";
	public static final 	String PASS = "ers";
	
	//update
	
	//List all the statuses
	public List<ERS_REIMBURSEMENT_STATUS> allStatus();
}

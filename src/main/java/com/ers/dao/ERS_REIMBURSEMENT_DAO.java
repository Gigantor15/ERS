package com.ers.dao;

import com.ers.beans.ERS_REIMBURSEMENT;

public interface ERS_REIMBURSEMENT_DAO {

	public static final 	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final	String USER = "ers";
	public static final 	String PASS = "ers";
	
	//insert
	void insert(ERS_REIMBURSEMENT record);
	//update
	
	//retrieve
}

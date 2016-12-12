package com.ers.dao;

import com.ers.beans.ERS_REIMBURSEMENT_TYPE;

public interface ERS_REIMBURSEMENT_TYPE_DAO {

	public static final 	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final	String USER = "ers";
	public static final 	String PASS = "ers";
	
	//reimbursement type
	public ERS_REIMBURSEMENT_TYPE reimbType(String type);
}

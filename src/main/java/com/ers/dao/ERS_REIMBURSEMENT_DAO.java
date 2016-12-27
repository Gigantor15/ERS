package com.ers.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.ers.beans.ERS_REIMBURSEMENT;
import com.ers.beans.ERS_REIMBURSEMENT_TYPE;
import com.ers.beans.ERS_USERS;

public interface ERS_REIMBURSEMENT_DAO {
	
	//retrieve
	public List<ERS_REIMBURSEMENT> queryAllEmp(ERS_USERS user) throws SQLException, NamingException;
	public List<ERS_REIMBURSEMENT> queryAllMan() throws SQLException, NamingException;
	//insert
	public void insert(double amount, ERS_USERS author, String description, int typeId)
			throws NamingException, Exception;
	//update
	public void update(int statVal, int reimbId, int resId, int empId) throws SQLException;
	
	
	public void close() throws SQLException;
}

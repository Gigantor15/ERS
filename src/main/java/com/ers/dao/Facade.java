package com.ers.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.ers.beans.ERS_USERS;
import com.ers.beans.ERS_REIMBURSEMENT;
import com.ers.impl.ERS_REIMBURSEMENT_IMPL;
import com.ers.impl.ERS_USERS_IMPL;

public class Facade {
	
	public ERS_USERS newUser(String username, String password) throws SQLException{
		return new ERS_USERS_IMPL().findUser(username, password);
	}
	
	public List<ERS_REIMBURSEMENT> queryAllEmp(ERS_USERS user) throws SQLException, NamingException{
		ERS_REIMBURSEMENT_DAO dao = new ERS_REIMBURSEMENT_IMPL();
		List<ERS_REIMBURSEMENT> list = dao.queryAllEmp(user);
		return list;
	}
	
	public List<ERS_REIMBURSEMENT> queryAllMan() throws SQLException, NamingException{
		ERS_REIMBURSEMENT_DAO dao = new ERS_REIMBURSEMENT_IMPL();
		List<ERS_REIMBURSEMENT> list = dao.queryAllMan();
		return list;
	}

}

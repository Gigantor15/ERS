package com.ers.dao;

import java.sql.SQLException;
import java.util.List;

import com.ers.beans.ERS_REIMBURSEMENT_TYPE;

public interface ERS_REIMBURSEMENT_TYPE_DAO {

	public List<ERS_REIMBURSEMENT_TYPE> queryAll() throws SQLException;
	public String getType(int id) throws SQLException;
	public void close() throws SQLException;
}

package com.ers.dao;

import java.sql.SQLException;
import java.util.List;

import com.ers.beans.ERS_USERS;

public interface ERS_USERS_DAO {

	
	

	//return user by username
	//public ERS_USERS getByUsername(String username);
	//public List<ERS_USERS> queryAll() throws SQLException;
	public ERS_USERS findUser(String username, String password) throws SQLException;
	public void close() throws SQLException;

}

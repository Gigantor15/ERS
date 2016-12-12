package com.ers.dao;

import java.sql.SQLException;

import com.ers.beans.ERS_USERS;

public interface ERS_USERS_DAO {

	
	

	//return user by username
	public ERS_USERS getByUsername(String username);
	
}

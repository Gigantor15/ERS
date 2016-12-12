package com.ers.dao;

import java.sql.SQLException;
import java.util.List;

import com.ers.beans.ERS_USER_ROLES;

public interface ERS_USER_ROLES_DAO {

	public static final 	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final	String USER = "ers";
	public static final 	String PASS = "ers";

	//retrieve user roles by ID
	public ERS_USER_ROLES getById(int roleId);
	
	public void close() throws SQLException;
	
}

package com.ers.middle;

import java.sql.SQLException;

import javax.naming.AuthenticationException;

import com.ers.beans.ERS_USERS;

public class BusinessDelegate {

	public ERS_USERS login(String username, String password) throws AuthenticationException, SQLException{
		return new UserService().siteUser(username, password);
	}
}

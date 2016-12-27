package com.ers.middle;

import java.sql.SQLException;

import javax.naming.AuthenticationException;

import com.ers.beans.ERS_USERS;
import com.ers.dao.Facade;

public class UserService {

	public ERS_USERS siteUser(String username, String password) throws SQLException, AuthenticationException{
		ERS_USERS user = new Facade().newUser(username, password);
		if(user.equals(null)){
			throw new AuthenticationException();
		}else if(user.getPassword().equals(password)){
			return user;
		}else{
			return null;
		}
	}
}

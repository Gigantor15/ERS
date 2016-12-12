package com.ers.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.ers.impl.ERS_USERS_IMPL;

public class Facade {


	
	public void Facade() {
		Connection conn = null;
		try {
			conn = ServiceLocator.getERSDatabase().getConnection();
			//TODO maybe take out everything below this
			conn.setAutoCommit(false); // Lamb enables transaction
			ERS_USERS_DAO users = new ERS_USERS_IMPL(conn);
			System.out.println(users.getByUsername("Awilliams").getFirstname());
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
}

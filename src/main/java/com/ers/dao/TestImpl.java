package com.ers.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.ers.impl.ERS_REIMBURSEMENT_IMPL;
import com.ers.impl.ERS_REIMBURSEMENT_STATUS_IMPL;
import com.ers.impl.ERS_USERS_IMPL;
import com.ers.middle.ServiceLocator;

public class TestImpl {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, NamingException {
		Connection conn = ServiceLocator.getERSDatabase().getConnection();
		
		Facade facade = new Facade();
		/*List<ERS_REIMBURSEMENT_STATUS> status = facade.getStatus(1);
		for(int i=0; i<status.size(); i++){
			System.out.println(facade.getStatus(1));
		}*/
		
		ERS_USERS_IMPL users = new ERS_USERS_IMPL();
		System.out.println("Finding a specific user");
		System.out.println(users.findUser("Awilliams", "welcome1"));
		
		ERS_REIMBURSEMENT_STATUS_IMPL status = new ERS_REIMBURSEMENT_STATUS_IMPL();
		System.out.println("Finding a specfic status");
		System.out.println(status.getStatus(1));
		System.out.println("Outputting all statuses");
		System.out.println(status.queryAll());
		
		ERS_REIMBURSEMENT_IMPL reimb = new ERS_REIMBURSEMENT_IMPL();
		System.out.println("All Reimbursements");
		System.out.println(reimb.queryAllMan());
		
		
		/*
		//testing database connection for all tables
		Statement stmt = conn.createStatement();
		//testing USER_ROLE table
		ResultSet rs = stmt.executeQuery("select * from ERS_USERS");
		System.out.println("Testing ERS_USERNAME connection");
		while(rs.next()){
			System.out.println(rs.getString("ERS_USERNAME"));
		}
		//testing ERS_REIMBURSEMENT_STATUS table
		rs = stmt.executeQuery("select * from ERS_REIMBURSEMENT_STATUS");
		System.out.println("Testing ERS_REIMBURSEMENT_STATUS connection");
		while(rs.next()){
			System.out.println(rs.getString("REIMB_STATUS"));
		}
		//testing ERS_REIMBURSEMENT_TYPE table
		rs = stmt.executeQuery("select * from ERS_REIMBURSEMENT_TYPE");
		System.out.println("Testing ERS_REIMBURSEMENT_TYPE connection");
		while(rs.next()){
			System.out.println(rs.getString("REIMB_TYPE"));
		}
		//testing ERS_USER_ROLES table
		rs = stmt.executeQuery("select * from ERS_USER_ROLES");
		System.out.println("Testing ERS_USER_ROLES connection");
		while(rs.next()){
			System.out.println(rs.getString("USER_ROLE"));
		}
		*/
		

	}
}

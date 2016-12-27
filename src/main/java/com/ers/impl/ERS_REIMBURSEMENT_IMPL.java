package com.ers.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.ers.beans.ERS_REIMBURSEMENT;
import com.ers.beans.ERS_REIMBURSEMENT_STATUS;
import com.ers.beans.ERS_REIMBURSEMENT_TYPE;
import com.ers.beans.ERS_USERS;
import com.ers.beans.ERS_USER_ROLES;
import com.ers.dao.ERS_REIMBURSEMENT_DAO;
import com.ers.middle.ServiceLocator;

public class ERS_REIMBURSEMENT_IMPL implements ERS_REIMBURSEMENT_DAO{

	private Connection conn;
	public ERS_REIMBURSEMENT_IMPL() throws SQLException{
		conn = ServiceLocator.getERSDatabase().getConnection();
		//this.conn = conn;
	}

	public List<ERS_REIMBURSEMENT> queryAllEmp(ERS_USERS user) throws SQLException, NamingException{
		List<ERS_REIMBURSEMENT> list = new ArrayList<>();
		String sql = "SELECT ERS_REIMBURSEMENT.REIMB_AMOUNT,"
				+ " ERS_REIMBURSEMENT.REIMB_ID,"
				+ " ERS_REIMBURSEMENT.REIMB_SUBMITTED,"
				+ " ERS_REIMBURSEMENT.REIMB_RESOLVED,"
				+ " ERS_REIMBURSEMENT.REIMB_RESOLVER,"
				+ " ERS_REIMBURSEMENT.REIMB_DESCRIPTION,"
				+ " ERS_USERS.ERS_USERS_ID AS AuthId,"
				+ " ERS_USERS.ERS_USERNAME AS AuthUser,"
				+ " ERS_USERS.ERS_PASSWORD AS AuthPass,"
				+ " ERS_USERS.USER_FIRST_NAME AS AuthFirst,"
				+ " ERS_USERS.USER_LAST_NAME AS AuthLast,"
				+ " ERS_USERS.USER_EMAIL AS AuthEmail,"
				+ " ERS_USERS.USER_ROLE_ID AS AuthRole,"
				+ " ERS_USERS.ERS_USERS_ID AS ResId,"
				+ " ERS_USERS.ERS_USERNAME AS ResUser,"
				+ " ERS_USERS.ERS_PASSWORD AS ResPass,"
				+ " ERS_USERS.USER_FIRST_NAME AS ResFirst,"
				+ " ERS_USERS.USER_LAST_NAME AS ResLast,"
				+ " ERS_USERS.USER_EMAIL AS ResEmail,"
				+ " ERS_USERS.USER_ROLE_ID AS ResRole,"
				+ " ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID AS StatusId,"
				+ " ERS_REIMBURSEMENT_STATUS.REIMB_STATUS AS Status,"
				+ " ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID AS TypeId,"
				+ " ERS_REIMBURSEMENT_TYPE.REIMB_TYPE AS Type"
				+ " FROM ERS_REIMBURSEMENT"
				+ " INNER JOIN ERS_REIMBURSEMENT_STATUS"
				+ " ON ERS_REIMBURSEMENT.REIMB_STATUS_ID = ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID"
				+ " INNER JOIN ERS_REIMBURSEMENT_TYPE"
				+ " ON ERS_REIMBURSEMENT.REIMB_TYPE_ID = ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID"
				+ " INNER JOIN ERS_USERS"
				+ " ON ERS_REIMBURSEMENT.REIMB_AUTHOR = ERS_USERS.ERS_USERS_ID"
				+ " LEFT JOIN ERS_USERS"
				+ " ON ERS_REIMBURSEMENT.REIMB_RESOLVER = ERS_USERS.ERS_USERS_ID";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		mapRowsEmp(rs, list, user);
		return list;
	}
	
	public void mapRowsEmp(ResultSet rs, List<ERS_REIMBURSEMENT> list, ERS_USERS user) throws SQLException{
		while(rs.next()){
			int userNum = rs.getInt("AuthorID");
			if(user.getId() == userNum){
				ERS_USER_ROLES authorRole = new ERS_USER_ROLES(
						rs.getInt("ERS_USER_ROLE_ID"),
						rs.getString("USER_ROLE"));
						
				ERS_USERS author = new ERS_USERS(
						rs.getInt("AuthId"), 
						rs.getString("AuthUser"), 
						rs.getString("AuthPass"), 
						rs.getString("AuthFirst"), 
						rs.getString("AuthLast"), 
						rs.getString("AuthEmail"), 
						authorRole);
				
				ERS_USER_ROLES resolverRole = new ERS_USER_ROLES(
						rs.getInt("ERS_USER_ROLE_ID"),
						rs.getString("USER_ROLE"));
				
				ERS_USERS resolver = new ERS_USERS(
						rs.getInt("ResId"), 
						rs.getString("ResUser"), 
						rs.getString("ResPass"), 
						rs.getString("ResFirst"), 
						rs.getString("ResLast"), 
						rs.getString("ResEmail"), 
						resolverRole);
				
				ERS_REIMBURSEMENT_STATUS statusId = new ERS_REIMBURSEMENT_STATUS(
						rs.getInt("REIMB_STATUS_ID"), 
						rs.getString("REIMB_STATUS"));
				
				ERS_REIMBURSEMENT_TYPE typeId = new ERS_REIMBURSEMENT_TYPE(
						rs.getInt("REIMB_TYPE_ID"), 
						rs.getString("REIMB_TYPE"));
				
				ERS_REIMBURSEMENT reimb = new ERS_REIMBURSEMENT(
						rs.getInt("REIMB_ID"),
						rs.getDouble("REIMB_AMOUNT"),
						rs.getTimestamp("REIMB_SUBMITTED"),
						rs.getTimestamp("REIMB_RESOLVED"),
						rs.getString("REIMB_DESCRIPTION"),
						author, resolver, statusId, typeId
						);
				list.add(reimb);
			}
		}
	}
	
	public List<ERS_REIMBURSEMENT> queryAllMan() throws SQLException, NamingException{
		List<ERS_REIMBURSEMENT> list = new ArrayList<>();
		String sql = "SELECT ERS_REIMBURSEMENT.REIMB_AMOUNT,"
				+ " ERS_REIMBURSEMENT.REIMB_ID,"
				+ " ERS_REIMBURSEMENT.REIMB_SUBMITTED,"
				+ " ERS_REIMBURSEMENT.REIMB_RESOLVED,"
				+ " ERS_REIMBURSEMENT.REIMB_RESOLVER,"
				+ " ERS_REIMBURSEMENT.REIMB_DESCRIPTION,"
				+ " ERS_USERS.ERS_USERS_ID AS AuthId,"
				+ " ERS_USERS.ERS_USERNAME AS AuthUser,"
				+ " ERS_USERS.ERS_PASSWORD AS AuthPass,"
				+ " ERS_USERS.USER_FIRST_NAME AS AuthFirst,"
				+ " ERS_USERS.USER_LAST_NAME AS AuthLast,"
				+ " ERS_USERS.USER_EMAIL AS AuthEmail,"
				+ " ERS_USERS.USER_ROLE_ID AS AuthRole,"
				+ " ERS_USERS.ERS_USERS_ID AS ResId,"
				+ " ERS_USERS.ERS_USERNAME AS ResUser,"
				+ " ERS_USERS.ERS_PASSWORD AS ResPass,"
				+ " ERS_USERS.USER_FIRST_NAME AS ResFirst,"
				+ " ERS_USERS.USER_LAST_NAME AS ResLast,"
				+ " ERS_USERS.USER_EMAIL AS ResEmail,"
				+ " ERS_USERS.USER_ROLE_ID AS ResRole,"
				+ " ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID AS StatusId,"
				+ " ERS_REIMBURSEMENT_STATUS.REIMB_STATUS AS Status,"
				+ " ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID AS TypeId,"
				+ " ERS_REIMBURSEMENT_TYPE.REIMB_TYPE AS Type"
				+ " FROM ERS_REIMBURSEMENT"
				+ " INNER JOIN ERS_REIMBURSEMENT_STATUS"
				+ " ON ERS_REIMBURSEMENT.REIMB_STATUS_ID = ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID"
				+ " INNER JOIN ERS_REIMBURSEMENT_TYPE"
				+ " ON ERS_REIMBURSEMENT.REIMB_TYPE_ID = ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID"
				+ " INNER JOIN ERS_USERS"
				+ " ON ERS_REIMBURSEMENT.REIMB_AUTHOR = ERS_USERS.ERS_USERS_ID"
				+ " LEFT JOIN ERS_USERS"
				+ " ON ERS_REIMBURSEMENT.REIMB_RESOLVER = ERS_USERS.ERS_USERS_ID";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		mapRowsMan(rs, list);
		return list;
	}
	
	public void mapRowsMan(ResultSet rs, List<ERS_REIMBURSEMENT> list) throws SQLException{
		while(rs.next()){
			ERS_USER_ROLES authorRole = new ERS_USER_ROLES(
					rs.getInt("ERS_USER_ROLE_ID"),
					rs.getString("USER_ROLE"));
						
			ERS_USERS author = new ERS_USERS(
					rs.getInt("AuthId"), 
					rs.getString("AuthUser"), 
					rs.getString("AuthPass"), 
					rs.getString("AuthFirst"), 
					rs.getString("AuthLast"), 
					rs.getString("AuthEmail"), 
					authorRole);
				
			ERS_USER_ROLES resolverRole = new ERS_USER_ROLES(
					rs.getInt("ERS_USER_ROLE_ID"),
					rs.getString("USER_ROLE"));
				
			ERS_USERS resolver = new ERS_USERS(
					rs.getInt("ResId"), 
					rs.getString("ResUser"), 
					rs.getString("ResPass"), 
					rs.getString("ResFirst"), 
					rs.getString("ResLast"), 
					rs.getString("ResEmail"), 
					resolverRole);
			
			ERS_REIMBURSEMENT_STATUS statusId = new ERS_REIMBURSEMENT_STATUS(
					rs.getInt("REIMB_STATUS_ID"), 
					rs.getString("REIMB_STATUS"));
			
			ERS_REIMBURSEMENT_TYPE typeId = new ERS_REIMBURSEMENT_TYPE(
					rs.getInt("REIMB_TYPE_ID"), 
					rs.getString("REIMB_TYPE"));
				
			ERS_REIMBURSEMENT reimb = new ERS_REIMBURSEMENT(
					rs.getInt("REIMB_ID"),
					rs.getDouble("REIMB_AMOUNT"),
					rs.getTimestamp("REIMB_SUBMITTED"),
					rs.getTimestamp("REIMB_RESOLVED"),
					rs.getString("REIMB_DESCRIPTION"),
					author, resolver, statusId, typeId
					);
			list.add(reimb);
			}
		}
	
	public void update(int statVal, int reimbId, int resId, int empId) throws SQLException{
		String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID=?, REIMB_RESOLVED=?, REIMB_RESOLVER=? WHERE REIMB_ID=? AND REIMB_AUTHOR=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, statVal);
		stmt.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
		stmt.setInt(3, resId);
		stmt.setInt(4, reimbId);
		stmt.setInt(5, empId);
		stmt.executeUpdate();
		close();
	}
	
	public void insert(double amount, ERS_USERS author, String description, int typeId)
			throws NamingException, Exception {
		String sql = "INSERT INTO ERS_REIMBURSEMENT(REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) values(?,?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		//reimbursement id
		stmt.setInt(1, new ERS_REIMBURSEMENT_IMPL().queryAllMan().size()+1);
		
		//reimbursement amount
		stmt.setDouble(2, amount);
		
		//submitted timestamp
		stmt.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
		
		//submission description
		stmt.setString(4, description);
		
		//author of submission
		stmt.setInt(5, author.getId());	//takes the author id from ERS_USERS
		
		//status of submission set to pending automatically for new submissions
		stmt.setInt(6, 1);
		
		//the type of the submission
		stmt.setInt(7, typeId);
		
		stmt.executeUpdate();

	}

	//TODO write the update for the reimbursement
	
	public void close() throws SQLException {
		conn.close();
		
	}

}

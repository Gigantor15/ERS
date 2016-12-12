package com.ers.beans;

public class ERS_USER_ROLES {
	private int id;
	private String role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "ERS_USERS [id=" + id + ", role=" + role + "]";
	}
	public ERS_USER_ROLES(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	public ERS_USER_ROLES() {
		super();
	}
	
	

}

package com.ers.beans;

public class ERS_USERS {
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private ERS_USER_ROLES roleId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ERS_USER_ROLES getRoleId() {
		return roleId;
	}
	public void setRoleId(ERS_USER_ROLES roleId) {
		this.roleId = roleId;
	}
	public ERS_USERS(int id, String username, String password, String firstname, String lastname, String email,
			ERS_USER_ROLES roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.roleId = roleId;
	}
	public ERS_USERS() {
		super();
	}

	@Override
	public String toString() {
		return "ERS_USERS [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", roleId=" + roleId + "]";
	}
	
	
	
}

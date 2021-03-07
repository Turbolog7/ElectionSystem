package com.electionbooth.bean;

public class Admin {
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", password=" + password + "]";
	}
}

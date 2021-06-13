package com.vti.entity;

public abstract class Account {
	private int 	AccID;
	private String 	FullName;
	private String	Email;
	private String 	Password;
	
	public Account() {
		
	}
	
	public Account(String fullName, String email, String password) {
		FullName = fullName;
		Email = email;
		Password = password;
	}
	
	public Account(int accID, String fullName, String email, String password) {
		AccID = accID;
		FullName = fullName;
		Email = email;
		Password = password;
	}

	public int getAccID() {
		return AccID;
	}

	public void setAccID(int accID) {
		AccID = accID;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString() {
		return "AcccountID: " + AccID + " | FullName: " + FullName +" | Email: " + 
					Email + " | Password=" + Password+" | Project: ";
	}
	
	
	
}

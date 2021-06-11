package com.vti.entity;

public abstract class Candidate {
	private int 	CandidateID;
	private String 	FirstName;
	private String	LastName;
	private String 	Phone;
	private String	Email;
	private String 	Password;
	private String 	Type;
	
	public Candidate(int candidateID, String firstName, String lastName, String phone, String email, String password,
			String type) {

		CandidateID = candidateID;
		FirstName = firstName;
		LastName = lastName;
		Phone = phone;
		Email = email;
		Password = password;
		Type = type;
	}
	
	public Candidate( String firstName, String lastName, String phone, String email, String password) {

		FirstName = firstName;
		LastName = lastName;
		Phone = phone;
		Email = email;
		Password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
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

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getCandidateID() {
		return CandidateID;
	}

	@Override
	public String toString() {
		return "CandidateID: " + CandidateID + " | FullName: " + FirstName +" "+ LastName
				+ " | Phone: " + Phone + " | Email: " + Email + " | Password=" + Password + " | Type: " + Type;
	}
	
	
	
}

package com.vti.entity;

import java.time.LocalDate;

import com.vti.ultis.ScannerUltis;

public class Account {
	private int id;
	private String email;
	private String username;
	private String fullname;
	private Department department;
	private Position position;
	private LocalDate createDate;
	
	private ScannerUltis sc;

	public Account() {
		sc = new ScannerUltis();
	}

	public Account(int id, String email, String username, String fullname, Department department, Position position,
			LocalDate createDate) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Account ID: " + id + " | Email: " + email + " | Username: " + username + " | Fullname: " + fullname
				+ " | Department: " + department.getName()+ " | Position: "+ position.getName()
				+ " | CreateDate: " + createDate;
	}


	
}

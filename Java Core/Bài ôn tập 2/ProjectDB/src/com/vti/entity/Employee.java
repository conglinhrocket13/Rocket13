package com.vti.entity;

public class Employee extends Account{

	public Employee(int accID, String fullName, String email, String password) {
		super(accID, fullName, email, password);
		
	}
		
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(String fullName, String email, String password) {
		super(fullName, email, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString()+" | Type: Employee";
	}
	
	
}

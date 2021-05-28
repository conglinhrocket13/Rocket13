package com.vti.entity;

public class Employee extends User {
	
	public Employee() {
		super();
		
	}

	public Employee(String name, double salary) {
		super(name, salary);
		
	}

	@Override
	public double caculatePay() {
		
		return getSalary() * 420;
		
	}
	
}

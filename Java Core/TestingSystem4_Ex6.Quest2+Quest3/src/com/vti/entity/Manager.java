package com.vti.entity;

public class Manager extends User {
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, double salary) {
		super(name, salary);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double caculatePay() {
		
		return getSalary() * 520;
	}
	
}

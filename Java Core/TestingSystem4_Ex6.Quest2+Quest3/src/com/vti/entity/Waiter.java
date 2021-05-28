package com.vti.entity;

public class Waiter extends User{

	public Waiter() {
		super();
	}
	
	public Waiter(String name, double salary) {
		super(name, salary);
		
	}
	
	@Override
	public double caculatePay() {
		
		return getSalary() * 220;
	}	
	
}

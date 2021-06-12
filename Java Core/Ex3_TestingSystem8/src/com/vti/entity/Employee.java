package com.vti.entity;

public class Employee<E> {
	private int id;
	private String name;
	private E[] salaries;

	private static int auto =0;
	
	
	public Employee(String name, E[] salaries) {
		this.id = ++auto;
		this.name = name;
		this.salaries = salaries;
	}
	
	
	public void ShowEmployee() {
		System.out.println("ID: "+id+" | Name: "+name+" | LastSaraly: "+salaries[salaries.length-1]);
	}
	
}

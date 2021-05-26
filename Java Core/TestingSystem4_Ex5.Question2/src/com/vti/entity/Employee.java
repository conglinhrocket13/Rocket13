package com.vti.entity;

import java.util.Scanner;

public class Employee extends Staff{
	private String job;
	private Scanner sc;
	public Employee() {
		super();
	}

	public Employee(String fullname, int age, Gender gender, String address, String job) {
		super(fullname, age, gender, address);
		this.job = job;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return super.toString()+String.format("%-10s | %-10s","Employee",job);
	}

	public void Add() {
		sc= new Scanner(System.in);
		System.out.println("---------Thêm nhân viên mới---------");
		super.Add();
		System.out.print("Nhập công việc : ");
		this.job= sc.nextLine();
	}	
}

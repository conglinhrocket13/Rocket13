package com.vti.entity;

import java.util.Scanner;

import javax.swing.AbstractAction;

public abstract class User {
	private String name;
	private double salary;
	public Scanner sc;
	
	public User() {
		sc = new Scanner(System.in);
	}

	public User(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	@Override
	public String toString() {
		return "Name      : " + name + "\nSalary    : " + salary;
	}
	
	public void Add() {
		System.out.println("Nhập thông tin user");
		System.out.print("Nhập tên      : ");
		this.name = sc.nextLine();
		System.out.print("Nhập mức lương: ");
		this.salary = sc.nextDouble();
		System.out.println();
		
	}
	
	public abstract double caculatePay();
	public void displayInfo() {
		System.out.println("------Thông tin mới nhập------");
		System.out.println(this.toString());
		System.out.println("Tổng lương: "+caculatePay());
	};
	
}

package com.vti.entity;

import java.util.Scanner;

public class Engineer extends Staff {
	private String technique;
	private Scanner sc;
	public Engineer() {
		super();
	}

	public Engineer(String fullname, int age, Gender gender, String address, String technique) {
		super(fullname, age, gender, address);
		this.technique = technique;
	}

	public String getTechnique() {
		return technique;
	}

	public void setTechnique(String technique) {
		this.technique = technique;
	}

	@Override
	public String toString() {
		return super.toString()+String.format("%-10s | %-10s","Engineer",technique);
	}
	
	public void Add() {
		sc= new Scanner(System.in);
		System.out.println("---------Thêm kỹ sư mới---------");
		super.Add();
		System.out.print("Nhập Ngành đào tạo: ");
		this.technique = sc.nextLine();
	}
}

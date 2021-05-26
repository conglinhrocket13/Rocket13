package com.vti.entity;

import java.util.Scanner;

public class Staff {
	private String fullname;
	private int age;
	private Gender gender;
	private String address;
	
	private Scanner sc;
	
	public Staff() {}
	
	public Staff(String fullname, int age, Gender gender, String address) {
		super();
		this.fullname = fullname;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public enum Gender{
		MALE , FEMALE, UNKNOW
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return String.format("%-15s | %-5s | %-10s | %-25s |", fullname,age,gender,address);
	}
	
	public void Add() {
		sc = new Scanner(System.in);
		System.out.print("Nhập họ tên    : ");
		this.fullname = sc.nextLine();
		System.out.print("Nhập tuổi      : ");
		this.age = sc.nextInt();
		Boolean lap=false;
		do {
		System.out.println("Nhập giới tính (1. Male   , 2.Female   , 3.Unknow  ) chọn số ! ");
		int n;
		System.out.print("Nhập số: ");
		n=sc.nextInt();
		switch(n) {
		case 1:
			this.gender = Gender.MALE;
			lap=true;
			break;
		case 2:
			this.gender = Gender.FEMALE;
			lap=true;
			break;
		case 3:
			this.gender = Gender.UNKNOW;
			lap=true;
			break;
		default:
			System.out.println("Nhập sai số! Xin nhập lại!");
		}
		}while(lap==false);
		sc.nextLine();
		System.out.print("Nhập địa chỉ   : ");
		this.address = sc.nextLine();
	}
}

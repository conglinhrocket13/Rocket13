package com.vti.entity;

import java.util.Scanner;

public class Student extends Person{
	private int ID;
	private float avgMark;
	private String email;
	public Scanner sc;
	
	public Student() {
		super();
		sc = new Scanner(System.in);
	}
	
	public Student(String name, Gender gender, String address, String birthday,
				int iD, float avgMark, String email) {
		super(name, gender, address, birthday);
		this.ID = iD;
		this.avgMark = avgMark;
		this.email = email;
	}
	
	public void inputInfo() {
		System.out.println("----------Nhập Sinh Viên----------");
		System.out.print("Nhập mã SV   : ");
		ID=sc.nextInt();
		super.inputInfo();
		System.out.print("Nhập điểm TB : ");
		avgMark=sc.nextFloat();
		System.out.print("Nhập email   : ");
		sc.nextLine();
		email=sc.nextLine();
	}
	
	public void showInfo() {
		System.out.println();
		System.out.println("--------------Thông Tin--------------");
		System.out.println("Mã Sinh Viên : "+ID);
		super.showInfo();
		System.out.println("Email        : "+email);
		System.out.println("Điểm TB      : "+avgMark);
		Boolean a=false;
		a=this.GetScholarship();
		if(a==true) {
			System.out.println("Học bổng     : Có");
		}else {
			System.out.println("Học bổng     : Không");
		}
	}
	
	public Boolean GetScholarship() {
		if(avgMark>=8) {
			return true;	
		}else {
			return false;
		}
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public float getAvgMark() {
		return avgMark;
	}
	public void setAvgMark(float avgMark) {
		this.avgMark = avgMark;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

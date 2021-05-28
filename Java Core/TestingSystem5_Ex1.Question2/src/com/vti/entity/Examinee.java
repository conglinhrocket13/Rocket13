package com.vti.entity;

import java.util.Scanner;

public class Examinee {
	private int ID;
	private String fullname;
	private String Address;
	private int PriorityLevel;
	public Scanner sc;
	
	public Examinee() {
		sc = new Scanner(System.in);
	}

	public Examinee(int iD, String fullname, String address, int priorityLevel) {
		super();
		ID = iD;
		this.fullname = fullname;
		Address = address;
		PriorityLevel = priorityLevel;
	}
	
	@Override
	public String toString() {
		return "SBD: " + ID + "| Họ Tên: " + fullname + "| Địa Chỉ: " + Address 
				+"| Mức Ưu Tiên:"+ PriorityLevel;
	}
	
	public void Add() {
		System.out.print("Nhập họ tên      : ");
		fullname = sc.nextLine();
		System.out.print("Nhập địa chỉ     : ");
		Address = sc.nextLine();
		System.out.print("Nhập mực ưu tiên : ");
		PriorityLevel = sc.nextInt();

	}
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getPriorityLevel() {
		return PriorityLevel;
	}

	public void setPriorityLevel(int priorityLevel) {
		PriorityLevel = priorityLevel;
	}


	
}

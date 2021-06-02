package com.vti.entity;

import java.util.ArrayList;

import com.vti.ultis.ScannerUltis;

public class Student {
	private int id;
	private String name;
	
	private static String college = "Đại học Bách Khoa";
	
	private static int autoID = 0;
	private static int COUNT = 0;
	
	public static int moneyGroup =0;
	
	public static int[] list = new int[7];
	
	public Student() {
		try {
		list[COUNT] = COUNT;
		this.id = ++autoID;
		System.out.print("Nhập tên sinh viên: ");
		this.name = ScannerUltis.inputString();
		++COUNT;
		}catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Đã vượt quá 7 student!");
		}
		
	}
	
	public String changeCollege() {
		System.out.print("Đổi tên college : ");
		return college=ScannerUltis.inputString();
	}
	
	public int CountAcc() {
		return COUNT;
	}
	
	@Override
	public String toString() {
		return "Student | id: " + id + "| Name: " + name +"| College: "+college;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getCollege() {
		return college;
	}
	public static void setCollege(String college) {
		Student.college = college;
	}
	
	
}

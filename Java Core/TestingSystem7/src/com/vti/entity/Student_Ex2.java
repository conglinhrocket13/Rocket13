package com.vti.entity;

import com.vti.ultis.ScannerUltis;

public class Student_Ex2 {
	private final int ID;
	private String name;
	
	public Student_Ex2() {
		System.out.print("Nhập ID  : ");
		ID=ScannerUltis.inputInt();
		ScannerUltis.fixScan();
		System.out.print("Nhập tên :");
		name = ScannerUltis.inputString();
		
	}
	
	public final void Study() {
		System.out.println(name+" đang học bài!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Student_Ex2 [ID=" + ID + ", name=" + name + "]";
	}
	
	
	
}

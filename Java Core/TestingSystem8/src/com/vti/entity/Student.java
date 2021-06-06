package com.vti.entity;

public class Student {
	private int id;
	private String name;
	
	private static int autoID=0;
	
	public Student(String name) {
		this.id= ++autoID;
		this.name=name;
	}

	public Student() {
		this.id = ++autoID;
		this.name = "Sinh viên "+autoID;
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

	@Override
	public String toString() {
		return "Student ID: " + id + "| Name: " + name;
	}
	
	
}

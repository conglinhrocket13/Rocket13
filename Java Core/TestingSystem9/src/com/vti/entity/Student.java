package com.vti.entity;

public class Student {
	public static int COUNT=0;
	private final int id;
	private String name;
	
	public Student(String name) {
		this.id = ++COUNT;
		this.name = name;
	}
	
	/**
	 * 
	 * @deprecated replace by {@link #getIDwithMSV()}
	 **/
	@Deprecated
	public int getId() {
		return id;
	}
	
	public String getIDwithMSV() {
		return "MSV"+id;
	}
	
	public String getName() {
		return name;
	}
	
	
}

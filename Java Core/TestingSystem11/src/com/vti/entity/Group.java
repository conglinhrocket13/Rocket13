package com.vti.entity;

public class Group {
	private int ID;
	private String Name;
	
	public Group(int iD, String name) {
		ID = iD;
		Name = name;
	}

	@Override
	public String toString() {
		return "Group ID: " + ID + " | Name: " + Name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
}

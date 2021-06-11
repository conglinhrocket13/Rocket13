package com.vti.entity;

import com.vti.ultis.ScannerUltis;

public class Department {
	private int id;
	private String name;
	private ScannerUltis sc;
	
	public Department() {
		sc = new ScannerUltis();
	}	

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
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

	public ScannerUltis getSc() {
		return sc;
	}

	public void setSc(ScannerUltis sc) {
		this.sc = sc;
	}

	@Override
	public String toString() {
		return "Department ID: " + id + " | Name: " + name;
	}
	
	
	
}

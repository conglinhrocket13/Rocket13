package com.vti.entity;

public class PrimaryStudent extends Student {
	private static int COUNT = 0;
	
	public PrimaryStudent() {
		super();
		++COUNT;
	}
	
	public int CountAcc() {
		
		return COUNT;
	}
	
}

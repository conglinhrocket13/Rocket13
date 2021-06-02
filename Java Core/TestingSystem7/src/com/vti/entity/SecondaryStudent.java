package com.vti.entity;

public class SecondaryStudent extends Student{
	
	private static int COUNT = 0;
	
	public SecondaryStudent() {
		super();
		++COUNT;
	}
	
	public int CountAcc() {
		
		return COUNT;
	}
}

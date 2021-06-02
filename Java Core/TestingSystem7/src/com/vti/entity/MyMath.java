package com.vti.entity;

public class MyMath {
	
	private static final float PI=3.14f;
	
	public static float sum(int a) {
//		PI = 3f;
		return a+PI;
	}
	
	public static int max(int a, int b) {
		if(a >= b) {
			return a;
		}else {
			return b;
		}
	}
	
	public static int min(int a, int b) {
		if(a <= b) {
			return a;
		}else {
			return b;
		}
	}
	
	public static int sum(int a, int b) {
		return a+b;
	}
}

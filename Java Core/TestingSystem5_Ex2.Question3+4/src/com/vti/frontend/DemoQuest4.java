package com.vti.frontend;

import com.vti.entity.MyMath;

public class DemoQuest4 {
	public static void main(String[] args) {
		MyMath a = new MyMath();
		
		System.out.println("Byte   : "+a.Sum(4, 6));
		System.out.println("Int    : "+a.Sum(4, 6));
		System.out.println("Float  : "+a.Sum(4.5f, 5.5f));
		System.out.println("Double : "+a.Sum(4.5, 5.5));
			
	}
}
